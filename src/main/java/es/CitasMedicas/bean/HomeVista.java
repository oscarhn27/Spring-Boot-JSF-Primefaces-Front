package es.CitasMedicas.bean;


import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import es.CitasMedicas.dominio.Usuario;
import es.CitasMedicas.excepciones.UserNotExistException;
import es.CitasMedicas.service.IAuthService;

@Named(value = "homeVista")
@SessionScoped
public class HomeVista implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario currentUser;
	
	@Autowired
	private IAuthService authService;
	
	public void inicio() throws IOException {
		if (!authService.isUsuarioActual()) {
			System.out.println("No hay usuarios conectados");
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}
		else {
			currentUser = authService.getUsuarioActual();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", currentUser.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void logout() throws IOException, UserNotExistException {
		authService.desautenticar();
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		
	}

}
