package es.CitasMedicas.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;

import es.CitasMedicas.dominio.UserType;
import es.CitasMedicas.dominio.Usuario;
import es.CitasMedicas.dominio.UsuarioToLog;
import es.CitasMedicas.excepciones.UserExistException;
import es.CitasMedicas.service.IAuthService;
import es.CitasMedicas.service.IServiceMedico;
import es.CitasMedicas.service.IServicePaciente;

@Named(value = "loginVista")
@SessionScoped
public class LoginVista implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String username, password, stringTipo;
	
	@Autowired
	private IAuthService authService;
	
	@Autowired
	private IServiceMedico medicoService;
	
	@Autowired
	private IServicePaciente pacienteService;
	
	public void inicio() throws IOException {
		if (authService.isUsuarioActual()) {
			System.out.println("Ya hay usuarios conectados");
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		}
	}
	
	public void login() throws IOException {
		UsuarioToLog userToLog = new UsuarioToLog(username, password);
		Usuario user;
		try {
			if (getTipo() == UserType.Medico) {
				user = medicoService.logear(userToLog);
			} else {
				user = pacienteService.logear(userToLog);
			}
		} catch (RestClientException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la autenticacion", "Usuario o contraseña incorrectos");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return;
		}
		try {
			user.setTipo(getTipo());
			authService.autenticar(user);
		} catch (UserExistException e) {
			System.out.println("Ya hay usuarios conectados");
		} finally {
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStringTipo() {
		return stringTipo;
	}

	public void setStringTipo(String stringTipo) {
		this.stringTipo = stringTipo;
	}

	public UserType getTipo() {
		return UserType.valueOf(stringTipo);
	}
	
	
}
