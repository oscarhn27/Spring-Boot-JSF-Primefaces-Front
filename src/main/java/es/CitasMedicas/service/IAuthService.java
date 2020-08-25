package es.CitasMedicas.service;

import es.CitasMedicas.dominio.UserType;
import es.CitasMedicas.dominio.Usuario;
import es.CitasMedicas.excepciones.UserExistException;
import es.CitasMedicas.excepciones.UserNotExistException;
	
public interface IAuthService {
	
	public void autenticar(Usuario user) throws UserExistException;
	
	public Usuario getUsuarioActual();
	
	public void setUsuarioActual(Usuario user) throws UserNotExistException;
	
	public boolean isUsuarioActual();
	
	public UserType getTipoOfUser() throws UserNotExistException;
	
	public void desautenticar() throws UserNotExistException;
	
}
