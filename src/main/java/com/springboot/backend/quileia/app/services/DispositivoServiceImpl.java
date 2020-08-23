package com.springboot.backend.quileia.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.quileia.app.entity.Dispositivo;
import com.springboot.backend.quileia.app.repository.DispositivoRepository;

@Service
public class DispositivoServiceImpl implements DispositivoService{
	
	@Autowired
	private DispositivoRepository dispositivoRepo;
	
	@Override
	@Transactional
	public Dispositivo save(Dispositivo dispositivo) {
		return dispositivoRepo.save(dispositivo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dispositivo> findAll() {
		return (List<Dispositivo>) dispositivoRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Dispositivo findById(Long id) {
		return dispositivoRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dispositivoRepo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Long contarConexion(Long id) {
		return dispositivoRepo.contarConexion(id);
	}

	@Override
	@Transactional(readOnly = true)
	public String buscarMac(String term) {
		return dispositivoRepo.buscarMac(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dispositivo> buscarMacById(Long id) {
		return dispositivoRepo.buscarMacById(id);
	}

}
