package com.springboot.backend.quileia.app.controllers;

import java.util.List;

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

import com.springboot.backend.quileia.app.entity.Dispositivo;
import com.springboot.backend.quileia.app.entity.Historico;
import com.springboot.backend.quileia.app.services.DispositivoService;
import com.springboot.backend.quileia.app.services.HistoricoService;

@CrossOrigin(origins = { "http://localhost:8100" })
@RestController
@RequestMapping("/dispositivo")
public class DispositivoRestController {

	@Autowired
	private DispositivoService dispositivoService;

	@Autowired
	private HistoricoService historicoService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findDispositivoById(@PathVariable Long id) {
		return ResponseEntity.ok().body(dispositivoService.findById(id));
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(dispositivoService.findAll());
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Dispositivo dispositivo) {

		Historico historico = new Historico();

		if (dispositivo.getConexionActual() != null) {
			Long countConexion = dispositivoService.contarConexion(dispositivo.getConexionActual().getId());

			if (countConexion >= 3) {
				String response = "No es posible ingresar más dispositivos a esta red";
				return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			historico.setClaveConRed(dispositivo.getConexionActual().getClave());
			historico.setNombreConRed(dispositivo.getConexionActual().getNombre());
			historico.setTipoCifradoConRed(dispositivo.getConexionActual().getTipoCifrado());
			historico.setTipoConRed(dispositivo.getConexionActual().getTipo());
			historico.setUsuarioConRed(dispositivo.getConexionActual().getUsuario());
		} else {
			historico.setClaveConRed(null);
			historico.setNombreConRed(null);
			historico.setTipoCifradoConRed(null);
			historico.setTipoConRed(0);
			historico.setUsuarioConRed(null);
		}

		String mac = dispositivoService.buscarMac(dispositivo.getMac());
		if (mac != null) {
			String response = "ya existe un dispositivo con esta mac";
			return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		historico.setIpDispositivo(dispositivo.getIp());
		historico.setMacDispositivo(dispositivo.getMac());
		historico.setTipoDispositivo(dispositivo.getTipo());

		historicoService.save(historico);

		return ResponseEntity.status(HttpStatus.CREATED).body(dispositivoService.save(dispositivo));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Dispositivo dispositivo, @PathVariable Long id) {

		Dispositivo dispositivoBD = dispositivoService.findById(id);
		if (dispositivoBD == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Dispositivo> dispositivos = dispositivoService.buscarMacById(dispositivo.getId());
		for (int i = 0; i < dispositivos.size(); i++) {
			if (dispositivo.getMac().equals(dispositivos.get(i).getMac())) {
				String response = "ya existe un dispositivo con esta mac";
				return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
		}

		dispositivoBD.setMac(dispositivo.getMac());
		dispositivoBD.setTipo(dispositivo.getTipo());
		dispositivoBD.setIp(dispositivo.getIp());
		dispositivoBD.setConected(dispositivo.isConected());

		if (dispositivo.getConexionActual() == null) {
			dispositivoBD.setConexionActual(null);
		} else {
			dispositivoBD.setConexionActual(dispositivo.getConexionActual());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(dispositivoService.save(dispositivoBD));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		dispositivoService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
