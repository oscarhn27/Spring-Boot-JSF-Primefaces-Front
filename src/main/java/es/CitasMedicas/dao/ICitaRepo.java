package es.citasmedicas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.citasmedicas.modelo.Cita;

@Repository
public interface ICitaRepo extends CrudRepository<Cita, Integer>{

}
