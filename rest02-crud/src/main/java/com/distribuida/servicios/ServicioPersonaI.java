package com.distribuida.servicios;

import java.util.List;

import com.distribuida.dto.Persona;

public interface ServicioPersonaI {
	List<Persona> listar();

	Persona buscarId(int id);

	void crear(Persona per);

	void actualizar(Persona per);

	void eliminar(Persona per);

}
