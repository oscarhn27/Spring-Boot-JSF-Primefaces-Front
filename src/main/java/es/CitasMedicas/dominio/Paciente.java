package es.CitasMedicas.dominio;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {

	private String nSS, numTarjeta, telefono, direccion;
	private List<Medico> medicos;
	private List<Cita> citasMedicas;
	
	public Paciente(){
		super();
		medicos = new ArrayList<Medico>();
		citasMedicas = new ArrayList<Cita>();
	}
	
	public Paciente(String nombre, String apellidos, String usuario, String clave, int idUsuario, String nSS, String numTarjeta, String telefono, String direccion, UserType tipo) {
		super(nombre, apellidos, usuario, clave, idUsuario, tipo);
		this.nSS = nSS;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
		medicos = new ArrayList<Medico>();
		citasMedicas = new ArrayList<Cita>();
	}

	public String getnSS() {
		return nSS;
	}

	public void setnSS(String nSS) {
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

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Cita> getCitasMedicas() {
		return citasMedicas;
	}

	public void setCitasMedicas(List<Cita> citasMedicas) {
		this.citasMedicas = citasMedicas;
	}

	
}
