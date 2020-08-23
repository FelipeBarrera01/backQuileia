package com.springboot.backend.quileia.app.services;

import java.util.List;

import com.springboot.backend.quileia.app.entity.Dispositivo;

public interface DispositivoService {
	public Dispositivo save(Dispositivo dispositivo);
	public List<Dispositivo> findAll();
	public Dispositivo findById(Long id);
	public void deleteById(Long id);
	public Long contarConexion(Long id);
	public String buscarMac(String term);
	public List<Dispositivo> buscarMacById(Long id);
}
