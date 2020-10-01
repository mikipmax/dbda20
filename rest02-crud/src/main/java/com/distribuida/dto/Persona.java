package com.distribuida.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.ValueGenerationType;
@Entity
@Table(name = "persona")
@NamedQueries({ @NamedQuery(name = "Persona.findAll", query = "select p from Persona p") })
public class Persona implements Serializable{
	//Autogenerado-Serial
	@Id
	
	private int id;
	private String nombre;
	private String direccion;
	private String correo;

	public Persona() {

	}

	public Persona(int id, String nombre, String direccion, String correo) {

		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}

	public Persona(int id) {

		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", correo=" + correo + "]";
	}

}
