package com.distribuida.servicios;

import java.util.List;

import com.distribuida.dto.Persona;

public interface ServicioPersonaI {

	List<Persona> listar();

	void crear(Persona persona);

	void editar(Persona persona);

	void eliminar(Persona persona);

	Persona buscarId(Persona persona);

}
