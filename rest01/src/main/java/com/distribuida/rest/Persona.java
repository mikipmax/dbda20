package com.distribuida.rest;

public class Persona {
	private Integer id;
	private String nombre;
	private String mensaje;

	public Persona(String nombre, String mensaje) {
		this.nombre = nombre;
		this.mensaje = mensaje;
	}
	public Persona(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	
	}
	public Persona() {

	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
