package es.CitasMedicas.bean;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import es.CitasMedicas.dominio.Cita;
import es.CitasMedicas.dominio.Medico;
import es.CitasMedicas.dominio.Paciente;
import es.CitasMedicas.dominio.UserType;
import es.CitasMedicas.dominio.Usuario;
import es.CitasMedicas.excepciones.UserNotExistException;
import es.CitasMedicas.service.IAuthService;

@Named(value = "homeVista")
@SessionScoped
public class HomeVista implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario currentUser;

	@Autowired
	private IAuthService authService;

	private boolean isMedico, mostrarMedicos, mostrarCitas, mostrarPacientes;

	public void inicio() throws IOException {
		try {
			currentUser = authService.getUsuarioActual();
			isMedico = authService.getTipoOfUser() == UserType.Medico;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", currentUser.getNombre());
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (UserNotExistException e) {
			System.out.println("No hay usuarios conectados");
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}
	}

	public void logout() throws IOException {
		try {
			authService.desautenticar();
		} catch (UserNotExistException e) {
			System.out.println("No puede desautenticar debido a que no hay un usuario guardado");
		}

		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");

	}

	public Usuario getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Usuario currentUser) {
		this.currentUser = currentUser;
	}

	public boolean getIsMedico() {
		return isMedico;
	}

	public void setIsMedico(boolean isMedico) {
		this.isMedico = isMedico;
	}
	
	public boolean isMostrarMedicos() {
		return mostrarMedicos;
	}

	public void setMostrarMedicos(boolean mostrarMedicos) {
		this.mostrarMedicos = mostrarMedicos;
	}
	
	public boolean isMostrarCitas() {
		return mostrarCitas;
	}
	
	public void setMostrarCitas(boolean mostrarCitas) {
		this.mostrarCitas = mostrarCitas;
	}
	
	public boolean isMostrarPacientes() {
		return mostrarPacientes;
	}

	public void setMostrarPacientes(boolean mostrarPacientes) {
		this.mostrarPacientes = mostrarPacientes;
	}

	public void mostrarMedicos() {
		hideVistas();
		mostrarMedicos = true;
	}
	
	public void mostrarPacientes() {
		hideVistas();
		mostrarPacientes = true;
	}
	
	public void mostrarCitas() {
		hideVistas();
		mostrarCitas = true;
	}

	public List<Medico> getMedicos(){
		if (isMedico)
			return null;
		return ((Paciente)currentUser).getMedicos();
	}
	
	public List<Paciente> getPacientes(){
		if (!isMedico)
			return null;
		return ((Medico)currentUser).getPacientes();
	}
	
	public List<Cita> getCitas(){
		if (isMedico) {
			return ((Medico)currentUser).getCitaDePacientes();
		} else {
			return ((Paciente)currentUser).getCitasMedicas();
		}
	}
	
	public String printDate(Date d) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return formatter.format(d);
	}
	
	private void hideVistas() {
		mostrarMedicos = false;
		mostrarCitas = false;
		mostrarPacientes = false;
	}

}
