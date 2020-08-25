package es.CitasMedicas.dominio;

import java.util.Date;

public class Cita {

	private int idCita, turno;
	private String motivoCita;
	private Date fechaHora;
	private Medico medicoC;
	private Paciente pacienteC;
	private Diagnostico diagnostico;
	
	public Cita() {
		
	}
	
	public Cita(int idCita, int turno, String motivoCita, Date fechaHora, Medico medicoC, Paciente pacienteC,
			Diagnostico diagnostico) {
		super();
		this.idCita = idCita;
		this.turno = turno;
		this.motivoCita = motivoCita;
		this.fechaHora = fechaHora;
		this.medicoC = medicoC;
		this.pacienteC = pacienteC;
		this.diagnostico = diagnostico;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Medico getMedicoC() {
		return medicoC;
	}

	public void setMedicoC(Medico medicoC) {
		this.medicoC = medicoC;
	}

	public Paciente getPacienteC() {
		return pacienteC;
	}

	public void setPacienteC(Paciente pacienteC) {
		this.pacienteC = pacienteC;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	
}
