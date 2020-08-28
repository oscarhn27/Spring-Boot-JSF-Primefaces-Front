package es.citasmedicas.service;

import java.util.List;
import java.util.Set;

import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Medico;
import es.citasmedicas.modelo.Paciente;
import es.citasmedicas.modelo.UsuarioToLog;
import javassist.NotFoundException;

public interface IServicePaciente {

	// Búsqueda
	public Paciente getPacienteById(int idPaciente);
	public Set<Cita> findCitasPaciente(Paciente p);
	public List<Paciente> getAllPacientes();
	public List<Integer> getUserByUserName(String usuario);
	public Paciente logear(UsuarioToLog user) throws NotFoundException;
	
	// Creación
	public Paciente crearYRegistrar(String nombre, String apellidos, String usario, 
			String clave, String nSS, String numTarjeta, String telefono, String direccion);
	public Paciente registrar(Paciente p);
	
	// Actualización
	public Paciente asociarMedico(Paciente p, Medico m);
	public Paciente asociarTelefono(Paciente p, String telefono);
	public Paciente asociarDireccion(Paciente p, String nDireccion);
	public Paciente asociarCita(Paciente p, Cita cita);
	public Paciente desasociarCita(Paciente p, Cita cita);
	
	// Eliminación
	public void deletePaciente(int idPaciente);
}
