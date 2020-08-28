package es.citasmedicas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.citasmedicas.modelo.Diagnostico;

@Repository
public interface IDiagnosticoRepo extends CrudRepository<Diagnostico, Integer>{

}
