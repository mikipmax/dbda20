package com.distribuida.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({ @NamedQuery(name = "Persona.findAll", query = "select p from Persona p") })
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cedula;
	private String direccion;
	@Column(name = "tipo_direccion")
	private int tipoDireccion;
	private String nombre;
	@Transient
	private TipoDireccion tipoDireccionE;
	public Persona() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(int tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDireccion getTipoDireccionE() {
		return tipoDireccionE;
	}

	public void setTipoDireccionE(TipoDireccion tipoDireccionE) {
		this.tipoDireccionE = tipoDireccionE;
	}
	
}
