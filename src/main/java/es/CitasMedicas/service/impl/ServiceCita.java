package es.citasmedicas.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.citasmedicas.dao.ICitaRepo;
import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Diagnostico;
import es.citasmedicas.modelo.Medico;
import es.citasmedicas.modelo.Paciente;
import es.citasmedicas.service.IServiceCita;
import es.citasmedicas.service.IServiceDiagnostico;

@Service
@Transactional
public class ServiceCita implements IServiceCita {

	@Autowired
	ICitaRepo citaRepo;
	
	@Autowired
	IServiceDiagnostico diagService;
	
	@Override
	public Cita crearYregistrar(Date fechaHora, String motivoCita, int turno, Paciente paciente, Medico medico) {
		Cita c = new Cita(fechaHora, motivoCita, paciente, medico, turno);
		return registrar(c);
	}

	@Override
	public Cita registrar(Cita cita) {
		return citaRepo.save(cita);
	}

	@Override
	public List<Cita> getAllCitas() {
		return StreamSupport
				.stream(citaRepo.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public Cita getCitaById(int idCita) {
		Optional<Cita> oc = citaRepo.findById(idCita);
		return oc.isPresent() ? oc.get() : null;
	}

	@Override
	public Cita establecerDiagnostico(Cita c, Diagnostico d) {
		c.setDiagnostico(d);
		return citaRepo.save(c);
	}

	@Override
	public Cita retrasarCita(Cita c, Date nuevaFecha) {
		c.setFechaHora(nuevaFecha);
		return citaRepo.save(c);
	}

	@Override
	public void deleteCita(int idCita) {
		Diagnostico d = getCitaById(idCita).getDiagnostico();
		if (d != null)
			diagService.deleteDiagnostico(d.getIdDiagnostico());
		citaRepo.deleteById(idCita);

	}

}
