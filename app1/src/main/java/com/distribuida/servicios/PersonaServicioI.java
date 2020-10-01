package com.distribuida.servicios;

import java.util.List;


import com.distribuida.dto.Persona;

public interface PersonaServicioI {
	List<Persona> listar();

	Persona buscarId(int id);

	

}
