package es.CitasMedicas.dominio;

public class Diagnostico {

	private String enfermedad, valoracionEspecialista;
	private int idDiagnostico;
	private Cita citaDiag;

	public Diagnostico() {
	
	}
	
	public Diagnostico(String enfermedad, String valoracionEspecialista, int idDiagnostico, Cita citaDiag) {
		super();
		this.enfermedad = enfermedad;
		this.valoracionEspecialista = valoracionEspecialista;
		this.idDiagnostico = idDiagnostico;
		this.citaDiag = citaDiag;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}

	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}

	public int getIdDiagnostico() {
		return idDiagnostico;
	}

	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	public Cita getCitaDiag() {
		return citaDiag;
	}

	public void setCitaDiag(Cita citaDiag) {
		this.citaDiag = citaDiag;
	}
	
}
