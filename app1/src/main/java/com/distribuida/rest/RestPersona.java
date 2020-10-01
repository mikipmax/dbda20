package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




import com.distribuida.dto.Persona;
import com.distribuida.servicios.PersonaServicioI;

@ApplicationScoped
@Path("/personas")
public class RestPersona {

	@Inject
	private PersonaServicioI servicioPersonaI;



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> listar() {
		return servicioPersonaI.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona buscarId(@PathParam("id") int id) {
		return servicioPersonaI.buscarId(id);
	}


}
