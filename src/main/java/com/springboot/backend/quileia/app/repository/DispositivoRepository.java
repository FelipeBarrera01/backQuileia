package com.springboot.backend.quileia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.quileia.app.entity.Dispositivo;

public interface DispositivoRepository extends CrudRepository<Dispositivo, Long>{

	
	@Query( value = "select count(*) from dispositivos dis where dis.id_con_actual = ?1" , nativeQuery = true)
	public Long contarConexion(Long id);
	
	@Query(value = "select mac from dispositivos d where d.mac = ?1" , nativeQuery = true)
	public String buscarMac(String term);
	
	@Query("SELECT d FROM Dispositivo d where d.id != ?1")
	public List<Dispositivo> buscarMacById(Long id);
}
