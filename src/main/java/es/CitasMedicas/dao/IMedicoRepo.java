package es.citasmedicas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.citasmedicas.modelo.Medico;

@Repository
public interface IMedicoRepo extends CrudRepository<Medico, Integer>{

	@Query("SELECT idUsuario FROM Usuario u WHERE u.usuario = ?1")
	public List<Integer> getUserByUserName(String usuario);
}
