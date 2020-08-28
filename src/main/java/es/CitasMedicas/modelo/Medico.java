package es.citasmedicas.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Paciente;
import es.citasmedicas.modelo.Usuario;

@Entity
@PrimaryKeyJoinColumn(name = "IDMEDICO")
@Table(name="MEDICO")
public class Medico extends Usuario {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="NUMCOLEGIADO")
	private String numColegiado;
	
	@ManyToMany(mappedBy = "medicos", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Paciente> pacientes = new HashSet<Paciente>();
	
	@OneToMany(mappedBy = "medicoC", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Cita> citaDePacientes = new HashSet<Cita>();
		
	public Medico() {
		
	}

	public Medico(String nombre, String apellidos, String usuario, String clave, String numColegiado) {
		super(nombre, apellidos, usuario, clave);
		this.numColegiado = numColegiado;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public void addPacientes(Paciente p) {
		this.pacientes.add(p);
	}

	public Set<Cita> getCitaDePacientes() {
		return citaDePacientes;
	}

	public void setCitaDePacientes(Set<Cita> citaDePacientes) {
		this.citaDePacientes = citaDePacientes;
	}

	public void addCita(Cita c) {
		citaDePacientes.add(c);
	}

	public boolean removePaciente(Paciente p) {
		return this.pacientes.remove(p);
	}

	public boolean removeCita(Cita c) {
		return this.citaDePacientes.remove(c);
	}
		
 }
