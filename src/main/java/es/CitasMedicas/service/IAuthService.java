package es.citasmedicas.service;

import es.citasmedicas.excepciones.UserExistException;
import es.citasmedicas.excepciones.UserNotExistException;
import es.citasmedicas.modelo.UserType;
import es.citasmedicas.modelo.Usuario;
	
public interface IAuthService {
	
	public void autenticar(Usuario user) throws UserExistException;
	
	public Usuario getUsuarioActual();
	
	public void setUsuarioActual(Usuario user) throws UserNotExistException;
	
	public boolean isUsuarioActual();
	
	public UserType getTipoOfUser() throws UserNotExistException;
	
	public void desautenticar() throws UserNotExistException;
	
}
