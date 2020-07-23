package com.distribuida.dto;

public class Direccion {
	private int idDireccion;
	private String descripcion;

	public Direccion() {
	}

	public Direccion(int idDireccion, String descripcion) {
		this.idDireccion = idDireccion;
		this.descripcion = descripcion;
	}

	public Direccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", descripcion=" + descripcion + "]";
	}

}
