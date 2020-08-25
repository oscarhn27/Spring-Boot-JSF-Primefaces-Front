package es.CitasMedicas.dominio;

public class Usuario {

	private String nombre, apellidos, usuario, clave;
	private UserType tipo;
	private int idUsuario;

	public Usuario() {
	}
	
	public Usuario(String nombre, String apellidos, String usuario, String clave, int idUsuario, UserType tipo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.clave = clave;
		this.idUsuario = idUsuario;
		this.tipo = tipo;
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
		return tipo;
	}

	public void setTipo(UserType tipo) {
		this.tipo = tipo;
	}
	
}
