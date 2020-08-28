package es.citasmedicas.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.citasmedicas.modelo.Usuario;

@Repository
public interface IUsuarioRepo  extends CrudRepository<Usuario, Integer>{

}
