package es.CitasMedicas.service;

import es.CitasMedicas.dominio.Paciente;
import es.CitasMedicas.dominio.UsuarioToLog;

public interface IServicePaciente {

	public Paciente logear(UsuarioToLog user);
}
