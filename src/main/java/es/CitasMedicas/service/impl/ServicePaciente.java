package es.citasmedicas.service.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.citasmedicas.dao.IPacienteRepo;
import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Medico;
import es.citasmedicas.modelo.Paciente;
import es.citasmedicas.modelo.UsuarioToLog;
import es.citasmedicas.service.IServiceCita;
import es.citasmedicas.service.IServiceMedico;
import es.citasmedicas.service.IServicePaciente;
import javassist.NotFoundException;

@Service
@Transactional
public class ServicePaciente implements IServicePaciente {
	
	@Autowired
	private IPacienteRepo pacienteRepo;
	
	@Autowired
	private IServiceCita citaService;
	
	@Autowired
	private IServiceMedico medicoService;

	@Override
	public Paciente getPacienteById(int idPaciente) {
		Optional<Paciente> op = pacienteRepo.findById(idPaciente);
		if(!op.isPresent())
			return null;
		Paciente p = op.get();
		return p;
	}

	@Override
	public Set<Cita> findCitasPaciente(Paciente p) {
		Optional<Paciente> op = pacienteRepo.findById(p.getIdUsuario());
		return op.isPresent() ? op.get().getCitasMedicas() : null;
	}

	@Override
	public List<Paciente> getAllPacientes() {
		List<Paciente> lPacientes = new LinkedList<Paciente>();
		for (Paciente p : pacienteRepo.findAll()) {
			lPacientes.add(p);
		}
		return lPacientes;
	}

	@Override
	public List<Integer> getUserByUserName(String usuario) {
		return pacienteRepo.getUserByUserName(usuario);
	}

	@Override
	public Paciente logear(UsuarioToLog user) throws NotFoundException {
		Optional<Integer> idUser= getUserByUserName(user.getUsuario()).stream().findFirst();
		if (idUser.isPresent()) {
			Paciente paciente = getPacienteById(idUser.get());
			if (paciente != null && paciente.getClave().equals(user.getClave()))
				return paciente;
		}
		throw new NotFoundException("No se ha encontrado el medico");
	}

	@Override
	public Paciente crearYRegistrar(String nombre, String apellidos, String usario, String clave, String nSS,
			String numTarjeta, String telefono, String direccion) {
		Paciente p = new Paciente(nombre, apellidos, usario, clave, nSS, numTarjeta, telefono, direccion);
		return registrar(p);
	}

	@Override
	public Paciente registrar(Paciente p) {
		return pacienteRepo.save(p);
	}

	@Override
	public Paciente asociarMedico(Paciente p, Medico m) {
		p.addMedico(m); 
		return pacienteRepo.save(p);
	}

	@Override
	public Paciente asociarTelefono(Paciente p, String telefono) {
		p.setTelefono(telefono);
		return pacienteRepo.save(p);
	}

	@Override
	public Paciente asociarDireccion(Paciente p, String nDireccion) {
		p.setDireccion(nDireccion);
		return pacienteRepo.save(p);
	}

	@Override
	public Paciente asociarCita(Paciente p, Cita cita) {
		p.addCita(cita);
		return pacienteRepo.save(p);
	}

	@Override
	public Paciente desasociarCita(Paciente p, Cita cita) {
		p.removeCita(cita);
		return p;
	}

	@Override
	public void deletePaciente(int idPaciente) {
		Paciente p = getPacienteById(idPaciente);
		p.getMedicos().stream().forEach(m -> medicoService.desasociarPaciente(m, p));
		Set<Cita> lCitas = p.getCitasMedicas();
		p.setCitasMedicas(new HashSet<Cita>());
		pacienteRepo.save(p);
		lCitas.stream()
					.forEach(c -> citaService.deleteCita(c.getIdCita()));
		pacienteRepo.deleteById(idPaciente);
		
	}

	

}
