package es.citasmedicas.service;

import java.util.Date;
import java.util.List;

import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Diagnostico;
import es.citasmedicas.modelo.Medico;
import es.citasmedicas.modelo.Paciente;

public interface IServiceCita {

	//Creación
	public Cita crearYregistrar(Date fechaHora, String motivoCita, int turno, Paciente paciente, Medico medico);
	public Cita registrar(Cita cita);
	
	// Búsqueda
	public List<Cita> getAllCitas();
	public Cita getCitaById(int idCita);

	//Actualizar
	public Cita establecerDiagnostico(Cita c, Diagnostico d);
	public Cita retrasarCita(Cita c, Date nuevaFecha);
	
	// Eliminación
	public void deleteCita(int idCita);

}
