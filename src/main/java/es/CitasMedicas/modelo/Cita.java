package es.citasmedicas.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.citasmedicas.modelo.Diagnostico;
import es.citasmedicas.modelo.Medico;
import es.citasmedicas.modelo.Paciente;

@Entity
@SequenceGenerator(name="GENERADOR_ID_CITA", initialValue=1, allocationSize=1)
@Table(name="CITA")
public class Cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERADOR_ID_CITA")
	@Column(name="IDCITA")
	private int idCita;
	
	@Column(name="FECHAHORA")
	private Date fechaHora;
	
	@Column(name="MOTIVOCITA")
	private String motivoCita;
	
	@Column(name="TURNO")
	private int turno; //Atributo 11
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDPACIENTE")
	private Paciente pacienteC;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IDMEDICO")
	private Medico medicoC;
	
	//Propietario de la entidad. Sólo uno en la relación
	@OneToOne(cascade = { CascadeType.ALL}) //Con el cascade se debe hacer un save del diagnostico. Este debería ser por tener propiedad
	@JoinColumn(name = "IDDIAGNOSTICO")
	private Diagnostico diagnostico;
	
	public Cita() {

	}

	public Cita(Date fechaHora, String motivoCita, Paciente pacienteC, Medico medicoC, int turno) {
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.turno = turno;
		this.pacienteC = pacienteC;
		this.medicoC = medicoC;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public Paciente getPacienteC() {
		return pacienteC;
	}

	public void setPacienteC(Paciente pacienteC) {
		this.pacienteC = pacienteC;
	}

	public Medico getMedicoC() {
		return medicoC;
	}

	public void setMedicoC(Medico medicoC) {
		this.medicoC = medicoC;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	

	
}
