package com.distribuida.servicios;

import java.util.List;

import com.distribuida.clases.Persona;

public interface PersonaServicioI {
	List<Persona> listar();

	void crear(Persona per);

	void editar(Persona per);

	void eliminar(Persona per);

}
