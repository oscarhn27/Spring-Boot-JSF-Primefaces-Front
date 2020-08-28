package es.citasmedicas.service;

import java.util.List;
import java.util.Set;

import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Paciente;
import es.citasmedicas.modelo.Medico;
import es.citasmedicas.modelo.UsuarioToLog;
import javassist.NotFoundException;

public interface IServiceMedico {

	// Creación
	public Medico crearYregistrar(String nombre, String apellidos, String usuario, String clave, String numColegiado);

	public Medico registrar(Medico medico);

	// Updates
	public Medico asociarPaciente(Medico m, Paciente p);

	public Medico asociarCita(Medico m, Cita c);

	public Medico desasociarPaciente(Medico m, Paciente p);

	public Medico desasociarCita(Medico m, Cita c);

	// Búsquedas
	public Set<Paciente> findPacientesAsociados(Medico m);

	public List<Medico> getAllMedicos();

	public Medico getMedicoById(int idMedico);

	public List<Integer> getUserByUserName(String usuario);
	
	public Medico logear(UsuarioToLog user) throws NotFoundException;

	// Eliminacion
	public void deleteMedico(int idMedico);

}
