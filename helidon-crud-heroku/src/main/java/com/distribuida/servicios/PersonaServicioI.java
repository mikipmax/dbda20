package com.distribuida.servicios;

import java.util.List;

import com.distribuida.clases.Persona;

public interface PersonaServicioI {
	List<Persona> listar();

	Persona buscarId(int id);

	void crear(Persona per);

	void editar(int id, Persona per);

	void eliminar(int id);

}
