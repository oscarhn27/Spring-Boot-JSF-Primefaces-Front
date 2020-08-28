package es.citasmedicas.service;

import java.util.List;

import es.citasmedicas.modelo.Cita;
import es.citasmedicas.modelo.Diagnostico;

public interface IServiceDiagnostico {

	// Busqueda
	public Diagnostico getDiagnosticoById(int idDiagnostico);
	public List<Diagnostico> getAllDiagnosticos();
	
	//Creación
    public Diagnostico crearYregistrar(String valoracionEspecialista, String enfermedad, Cita cita);
    public Diagnostico registrar(Diagnostico d);
    
    //Update
    public Diagnostico actualizarEnfermedad(Diagnostico d, String nEnfermedad);
    public Diagnostico actualizarValoracion(Diagnostico d, String nValoracion);
    
    // Eliminación
    public void deleteDiagnostico(int idDiagnostico);

}
