package es.citasmedicas.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.citasmedicas.dao.IMedicoRepo;
import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Medico;
import es.citasmedicas.modelo.Paciente;
import es.citasmedicas.modelo.UsuarioToLog;
import es.citasmedicas.service.IServiceMedico;
import javassist.NotFoundException;

@Service
@Transactional
public class ServiceMedico implements IServiceMedico{
	
	@Autowired
	IMedicoRepo medicoRepo;

	@Override
	public Medico crearYregistrar(String nombre, String apellidos, String usuario, String clave, String numColegiado) {
		Medico m = new Medico(nombre, apellidos, usuario, clave, numColegiado);
		return registrar(m);
	}

	@Override
	public Medico registrar(Medico medico) {
		return medicoRepo.save(medico);
	}

	@Override
	public Medico asociarPaciente(Medico m, Paciente p) {
		m.addPacientes(p);
		return medicoRepo.save(m);
	}

	@Override
	public Medico asociarCita(Medico m, Cita c) {
		m.addCita(c);
		return medicoRepo.save(m);
	}

	@Override
	public Medico desasociarPaciente(Medico m, Paciente p) {
		if(m.removePaciente(p)) {
			m.setCitaDePacientes(
				m.getCitaDePacientes().stream()
				.filter(c -> c.getPacienteC().getIdUsuario() != p.getIdUsuario())
				.collect(Collectors.toSet())
			);
			return medicoRepo.save(m);
		}
		return null;
	}

	@Override
	public Medico desasociarCita(Medico m, Cita c) {
		m.removeCita(c);
		return m;
	}

	@Override
	public Set<Paciente> findPacientesAsociados(Medico m) {
		if(m == null) 
			return null;
		Optional<Medico> om = medicoRepo.findById(m.getIdUsuario());
		return om.isPresent() ? om.get().getPacientes() : null;
	}

	@Override
	public List<Medico> getAllMedicos() {
		List<Medico> lMedicos = new LinkedList<Medico>();
		for(Medico m : medicoRepo.findAll()) {
			lMedicos.add(m);
		}
		return lMedicos;
	}

	@Override
	public Medico getMedicoById(int idMedico) {
		Optional<Medico> om = medicoRepo.findById(idMedico);
		return om.isPresent() ? om.get() : null;
	}

	@Override
	public List<Integer> getUserByUserName(String usuario) {
		return medicoRepo.getUserByUserName(usuario);
	}

	@Override
	public Medico logear(UsuarioToLog user) throws NotFoundException {
		Optional<Integer> idUser= getUserByUserName(user.getUsuario()).stream().findFirst();
		if (idUser.isPresent()) {
			Medico medico = getMedicoById(idUser.get());
			if (medico != null && medico.getClave().equals(user.getClave()))
				return medico;
		}
		throw new NotFoundException("No se ha encontrado el medico");
	}

	@Override
	public void deleteMedico(int idMedico) {
		medicoRepo.deleteById(idMedico);
	}

}
