package com.distribuida.proxies;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.clases.Persona;

public interface PersonaProxy {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Persona> lista();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Persona buscar(@PathParam("id") int id);

	@POST
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	void crear(Persona per);

	@PUT
	@Path("/actualizar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	void actualizar(@PathParam("id") int id, Persona per);

	@DELETE
	@Path("/eliminar/{id}")
	void eliminar(@PathParam("id") int id);

}
