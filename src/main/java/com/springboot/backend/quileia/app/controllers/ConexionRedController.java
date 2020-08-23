package com.springboot.backend.quileia.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.quileia.app.entity.ConexionRed;
import com.springboot.backend.quileia.app.services.ConexionRedService;

@CrossOrigin(origins = { "http://localhost:8100" })
@RestController
@RequestMapping("/conexion")
public class ConexionRedController {

	@Autowired
	private ConexionRedService conexionResService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(conexionResService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok().body(conexionResService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ConexionRed conexionRed){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(conexionResService.save(conexionRed));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody ConexionRed conexionRed , @PathVariable Long id){
		
		ConexionRed conexionBD = conexionResService.findById(id);
		if(conexionBD == null) {
			return ResponseEntity.notFound().build();
		}
		
		conexionBD.setTipo(conexionRed.getTipo());
		conexionBD.setNombre(conexionRed.getNombre());
		conexionBD.setTipoCifrado(conexionRed.getTipoCifrado());
		conexionBD.setUsuario(conexionRed.getUsuario());
		conexionBD.setClave(conexionRed.getClave());
		return ResponseEntity.status(HttpStatus.CREATED).body(conexionResService.save(conexionBD));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		conexionResService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
