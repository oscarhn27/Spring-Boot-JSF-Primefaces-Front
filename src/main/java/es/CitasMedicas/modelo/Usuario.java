package es.citasmedicas.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
@SequenceGenerator(name="GENERADOR_ID_USER", initialValue = 1, allocationSize = 1)
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="APELLIDOS")
	private String apellidos;
	
	@Column(name="USUARIO")
	private String usuario;
	
	@Column(name="CLAVE")
	private String clave;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERADOR_ID_USER")
	@Column(name="IDUSUARIO")
	private int idUsuario;
	
	public Usuario() {
		
	}

	public Usuario(String nombre, String apellidos, String usuario, String clave) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public UserType getTipo() {
		if (this instanceof Medico)
			return UserType.Medico;
		else if (this instanceof Paciente)
			return UserType.Paciente;
		else return null;
	}
	
	@Override
	public String toString() {
		return "Usuario ("+idUsuario+")[nombre=" + nombre + ", apellidos=" 
				+ apellidos + ", usuario=" + usuario + ", clave=" + clave +"]";
	}

	
	
	
}
