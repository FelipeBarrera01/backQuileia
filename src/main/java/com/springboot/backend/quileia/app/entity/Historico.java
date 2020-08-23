package com.springboot.backend.quileia.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "historicos")
public class Historico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo_con_red")
	private int tipoConRed;

	@Column(name = "nombre_con_red")
	private String nombreConRed;
	
	@Column(name = "tipo_cifrado_con_red")
	private String tipoCifradoConRed;
	
	@Column(name = "usuario_con_red")
	private String usuarioConRed;

	@Column(name = "clave_con_red")
	private String claveConRed;

	@Column(name = "ip_dispositivo")
	private String ipDispositivo;

	@Column(name = "mac_dispositivo")
	private String macDispositivo;

	@Column(name = "tipo_dispositivo")
	private String tipoDispositivo;

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getTipoConRed() {
		return tipoConRed;
	}



	public void setTipoConRed(int tipoConRed) {
		this.tipoConRed = tipoConRed;
	}



	public String getNombreConRed() {
		return nombreConRed;
	}



	public void setNombreConRed(String nombreConRed) {
		this.nombreConRed = nombreConRed;
	}



	public String getTipoCifradoConRed() {
		return tipoCifradoConRed;
	}



	public void setTipoCifradoConRed(String tipoCifradoConRed) {
		this.tipoCifradoConRed = tipoCifradoConRed;
	}



	public String getUsuarioConRed() {
		return usuarioConRed;
	}



	public void setUsuarioConRed(String usuarioConRed) {
		this.usuarioConRed = usuarioConRed;
	}



	public String getClaveConRed() {
		return claveConRed;
	}



	public void setClaveConRed(String claveConRed) {
		this.claveConRed = claveConRed;
	}



	public String getIpDispositivo() {
		return ipDispositivo;
	}



	public void setIpDispositivo(String ipDispositivo) {
		this.ipDispositivo = ipDispositivo;
	}



	public String getMacDispositivo() {
		return macDispositivo;
	}



	public void setMacDispositivo(String macDispositivo) {
		this.macDispositivo = macDispositivo;
	}



	public String getTipoDispositivo() {
		return tipoDispositivo;
	}



	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = -1275330999318464504L;

}
