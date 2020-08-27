package es.CitasMedicas.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.CitasMedicas.dominio.Paciente;
import es.CitasMedicas.dominio.UsuarioToLog;

@Service
public class ServicePaciente implements IServicePaciente {

private final static String URL = "http://localhost:8080/pacientes";
	
	HttpHeaders headers = new HttpHeaders();
	
	@Autowired
	RestTemplate restTemplate;
	
	public ServicePaciente() {
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
	}
	
	@Override
	public Paciente logear(UsuarioToLog user) {
		HttpEntity<UsuarioToLog> entity = new HttpEntity<UsuarioToLog>(user, headers);
		return restTemplate.exchange(URL+"/log", HttpMethod.POST, entity, Paciente.class).getBody();
	}

}
