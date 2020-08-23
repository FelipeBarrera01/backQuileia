package com.springboot.backend.quileia.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.quileia.app.services.HistoricoService;

@CrossOrigin(origins = { "http://localhost:8100" })
@RestController
@RequestMapping("/historico")
public class HistoricoController {

	@Autowired
	private HistoricoService historicoService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok().body(historicoService.findAll());
	}
	
	@GetMapping("/filtro-red/{term}")
	public ResponseEntity<?> findByRed(@PathVariable String term){
		return ResponseEntity.ok().body(historicoService.findNombreRed(term));
	}
	
	@GetMapping("/filtro-mac/{term}")
	public ResponseEntity<?> findByMac(@PathVariable String term){
		return ResponseEntity.ok().body(historicoService.findByMacDispositivo(term));
	}
}
