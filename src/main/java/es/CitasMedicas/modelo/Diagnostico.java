package es.citasmedicas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.citasmedicas.modelo.Cita;

@Entity
@SequenceGenerator(name="GENERADOR_ID_DIAG", initialValue=1, allocationSize=1)
@Table(name="DIAGNOSTICO")
public class Diagnostico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERADOR_ID_DIAG")
	@Column(name="IDDIAGNOSTICO")
	private int idDiagnostico;
	
	@Column(name="VALORACIONESPECIALISTA")
	private String valoracionEspecialista;
	
	@Column(name="ENFERMEDAD")
	private String enfermedad;
	
	@OneToOne(mappedBy = "diagnostico") //COmo se llama la variable referencia en la otra clase. JAVA
	private Cita citaDiag;
	
	public Diagnostico() {
		
	}

	public Diagnostico(String valoracionEspecialista, String enfermedad, Cita citaDiag) {
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
		this.citaDiag = citaDiag;
	}

	public int getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}

	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public Cita getCitaDiag() {
		return citaDiag;
	}

	public void setCitaDiag(Cita citaDiag) {
		this.citaDiag = citaDiag;
	}
	
	
	
}
