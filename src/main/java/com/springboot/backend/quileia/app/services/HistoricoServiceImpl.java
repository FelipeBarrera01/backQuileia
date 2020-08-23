package com.springboot.backend.quileia.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.quileia.app.entity.Historico;
import com.springboot.backend.quileia.app.repository.HistoricoRepository;

@Service
public class HistoricoServiceImpl implements  HistoricoService{

	@Autowired
	private HistoricoRepository historicoRepo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Historico> findAll() {
		return (List<Historico>) historicoRepo.findAll();
	}

	@Override
	@Transactional
	public void save(Historico historico) {
		historicoRepo.save(historico);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Historico> findNombreRed(String term) {
		return historicoRepo.findNombreRed(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Historico> findByMacDispositivo(String term) {
		return historicoRepo.findByMacDispositivo(term);
	}

	

}
