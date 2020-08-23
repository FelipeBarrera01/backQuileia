package com.springboot.backend.quileia.app.services;

import java.util.List;

import com.springboot.backend.quileia.app.entity.ConexionRed;



public interface ConexionRedService {
	public ConexionRed save(ConexionRed conexionRed);
	public List<ConexionRed> findAll();
	public ConexionRed findById(Long id);
	public void deleteById(Long id);

}
