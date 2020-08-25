package es.CitasMedicas.service;

import org.springframework.stereotype.Service;

import es.CitasMedicas.dominio.UserType;
import es.CitasMedicas.dominio.Usuario;
import es.CitasMedicas.excepciones.UserExistException;
import es.CitasMedicas.excepciones.UserNotExistException;

@Service
public class AuthService implements IAuthService {

	static private Usuario user;
	
	public AuthService() {
	}
	
	@Override
	public void autenticar(Usuario user) throws UserExistException{
		if(isUsuarioActual())
			throw new UserExistException();
		AuthService.user = user;
	}

	@Override
	public Usuario getUsuarioActual() {
		return user;
	}
	
	@Override
	public void setUsuarioActual(Usuario user) throws UserNotExistException {
		if(!isUsuarioActual() || AuthService.user.getIdUsuario() != user.getIdUsuario()) {
			throw new UserNotExistException();
		}
		AuthService.user = user;
	}

	@Override
	public boolean isUsuarioActual() {
		return user != null;
	}

	@Override
	public UserType getTipoOfUser() throws UserNotExistException{
		if(!isUsuarioActual())
			throw new UserNotExistException();
		return user.getTipo();
	}

	@Override
	public void desautenticar() throws UserNotExistException{
		if(!isUsuarioActual())
			throw new UserNotExistException();
		user = null;

	}

}
