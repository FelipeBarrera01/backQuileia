package com.springboot.backend.quileia.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dispositivos")
public class Dispositivo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mac;
	
	private String tipo;
	
	private boolean isConected;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_con_actual")
	private ConexionRed conexionActual;
	
	private String ip;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMac() {
		return mac;
	}


	public void setMac(String mac) {
		this.mac = mac;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public boolean isConected() {
		return isConected;
	}


	public void setConected(boolean isConected) {
		this.isConected = isConected;
	}


	public ConexionRed getConexionActual() {
		return conexionActual;
	}


	public void setConexionActual(ConexionRed conexionActual) {
		this.conexionActual = conexionActual;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 5353724276679662420L;

}
