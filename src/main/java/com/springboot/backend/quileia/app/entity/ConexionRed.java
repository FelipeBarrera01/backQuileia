package com.springboot.backend.quileia.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conexion_red")
public class ConexionRed implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int tipo;
	
	private String nombre;
	
	@Column(name = "tipo_cifrado")
	private String tipoCifrado;
	
	private String usuario;
	
	private String clave;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getTipoCifrado() {
		return tipoCifrado;
	}



	public void setTipoCifrado(String tipoCifrado) {
		this.tipoCifrado = tipoCifrado;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 7428349305685100865L;

}
