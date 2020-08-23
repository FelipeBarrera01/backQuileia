package com.springboot.backend.quileia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.quileia.app.entity.Historico;

public interface HistoricoRepository extends CrudRepository<Historico, Long> {

	@Query("SELECT h FROM Historico h WHERE h.macDispositivo LIKE ?1%")
	List<Historico> findByMacDispositivo(String term);
	
	@Query("SELECT h FROM Historico h WHERE h.nombreConRed LIKE ?1%")
	List<Historico> findNombreRed(String term);
	
}
