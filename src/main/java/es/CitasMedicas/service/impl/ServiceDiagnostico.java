package es.citasmedicas.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.citasmedicas.dao.IDiagnosticoRepo;
import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Diagnostico;
import es.citasmedicas.service.IServiceDiagnostico;

@Service
@Transactional
public class ServiceDiagnostico implements IServiceDiagnostico {

	@Autowired
	IDiagnosticoRepo diagRepo;
	
	@Override
	public Diagnostico getDiagnosticoById(int idDiagnostico) {
		Optional<Diagnostico> od = diagRepo.findById(idDiagnostico);
		return od.isPresent() ? od.get() : null;
	}

	@Override
	public List<Diagnostico> getAllDiagnosticos() {
		return StreamSupport
				.stream(diagRepo.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public Diagnostico crearYregistrar(String valoracionEspecialista, String enfermedad, Cita cita) {
		Diagnostico d = new Diagnostico(valoracionEspecialista, enfermedad, cita);
		return registrar(d);
	}

	@Override
	public Diagnostico registrar(Diagnostico d) {
		return diagRepo.save(d);
	}

	@Override
	public Diagnostico actualizarEnfermedad(Diagnostico d, String nEnfermedad) {
		d.setEnfermedad(nEnfermedad);
		return diagRepo.save(d);
	}

	@Override
	public Diagnostico actualizarValoracion(Diagnostico d, String nValoracion) {
		d.setValoracionEspecialista(nValoracion);
		return diagRepo.save(d);
	}

	@Override
	public void deleteDiagnostico(int idDiagnostico) {
		diagRepo.deleteById(idDiagnostico);

	}

}
