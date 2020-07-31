package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Persona;
import com.distribuida.servicios.ServicioPersonaI;

@ApplicationScoped
@Path("/personas")
public class RestPersona {
	@Inject
	private ServicioPersonaI servicioPersonaI;

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

	@POST
	@Path("/crear")
	// @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void crear(Persona per) {
		servicioPersonaI.crear(per);
	}

	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Persona per) {
		servicioPersonaI.actualizar(per);
	}

	@DELETE
	@Path("/eliminar/{id}")
	public void eliminar(Persona per) {
		servicioPersonaI.eliminar(per);
	}
}
