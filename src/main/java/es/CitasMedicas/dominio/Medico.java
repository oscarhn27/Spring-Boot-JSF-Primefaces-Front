package es.CitasMedicas.dominio;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Usuario{

	private String numColegiado;
	private List<Paciente> pacientes;
	private List<Cita> citaDePacientes;
	
	public Medico(){
		super();
		pacientes = new ArrayList<Paciente>();
		citaDePacientes = new ArrayList<Cita>();
	}
	
	public Medico(String nombre, String apellidos, String usuario, String clave, int idUsuario, String numColegiado, UserType tipo) {
		super(nombre, apellidos, usuario, clave, idUsuario, tipo);
		this.numColegiado = numColegiado;
		pacientes = new ArrayList<Paciente>();
		citaDePacientes = new ArrayList<Cita>();
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Cita> getCitaDePacientes() {
		return citaDePacientes;
	}

	public void setCitaDePacientes(List<Cita> citaDePacientes) {
		this.citaDePacientes = citaDePacientes;
	}
	
 }
