package es.citasmedicas.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Medico;
import es.citasmedicas.modelo.Usuario;

@Entity
@PrimaryKeyJoinColumn(name = "IDPACIENTE")
@Table(name = "PACIENTE")
public class Paciente extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="NSS")
	private String nSS;
	
	@Column(name="NUMTARJETA")
	private String numTarjeta;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	@Column(name="DIRECCION")
	private String direccion;

	@OneToMany(mappedBy="pacienteC", fetch = FetchType.EAGER, cascade = CascadeType.ALL) //Mapeando por Atributos java
	private Set<Cita> citasMedicas = new HashSet<Cita>();

	//Referencias (nombres) de la base de datos
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			  name = "MEDICO_PACIENTE", 
			  joinColumns = @JoinColumn(name = "IDPACIENTE"),
			  inverseJoinColumns = @JoinColumn(name = "IDMEDICO"))
	private Set<Medico> medicos = new HashSet<Medico>();
	
	public Paciente() {
		
	}

	public Paciente(String nombre, String apellidos, String usario, String clave, String nSS, String numTarjeta,
			String telefono, String direccion) {
		super(nombre, apellidos, usario, clave);
		this.nSS = nSS;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public String getnSS() {
		return nSS;
	}

	public void setNSS(String nSS) {
		this.nSS = nSS;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Cita> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(Set<Cita> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}
	
	public void addMedico(Medico m) {
		medicos.add(m);
	}

	public void addCita(Cita cita) {
		citasMedicas.add(cita);
	}

	public Set<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(Set<Medico> medicos) {
		this.medicos = medicos;
	}

	public void setnSS(String nSS) {
		this.nSS = nSS;
	}

	public void removeCita(Cita cita) {
		this.citasMedicas.remove(cita);
	}
	
	
	
}