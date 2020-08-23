package com.springboot.backend.quileia.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.quileia.app.entity.ConexionRed;
import com.springboot.backend.quileia.app.repository.ConexionRedRepository;

@Service
public class ConexionRedServiceImpl implements ConexionRedService{

	@Autowired
	private ConexionRedRepository conexionRedRepo;
	
	@Override
	@Transactional
	public ConexionRed save(ConexionRed conexionRed) {
		return conexionRedRepo.save(conexionRed);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConexionRed> findAll() {
		return (List<ConexionRed>) conexionRedRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ConexionRed findById(Long id) {
		return conexionRedRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		conexionRedRepo.deleteById(id);
	}


}
