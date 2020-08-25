package es.CitasMedicas.service;

import es.CitasMedicas.dominio.Medico;
import es.CitasMedicas.dominio.UsuarioToLog;

public interface IServiceMedico {

	public Medico logear(UsuarioToLog user);
}
