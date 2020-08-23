package com.springboot.backend.quileia.app.services;

import java.util.List;

import com.springboot.backend.quileia.app.entity.Historico;

public interface HistoricoService {
	public List<Historico> findAll(); 
	public void save(Historico historico);
	public List<Historico> findNombreRed(String term);
	public List<Historico> findByMacDispositivo(String term);

}
