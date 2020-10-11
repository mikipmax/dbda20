package com.distribuida.dto;

public class TipoDireccion {

	private Integer id;
	private String descripcion;

	public TipoDireccion() {

	}

	public TipoDireccion(int id, String descipcion) {
		this.id = id;
		this.descripcion = descipcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
