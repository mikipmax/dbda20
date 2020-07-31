package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/personas")
@ApplicationScoped
public class PersonasRest {
	// http://servidor:puerto/contexto/PATH/hola/{nombre}
	// uri efectivo: http://localhost:8080/rest01/hola/{nombre}
	@Inject
	private ServicioPersonas servicio;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> hola() {
		
		return servicio.listar();
	}
	@GET @Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id") Integer id) {
		
		Persona per= servicio.buscar(id);
		if(per!=null) {
			return Response.status(Response.Status.OK)
					.entity(per)
					.build();
		}else
		{
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity("Persona no encontrada")
					.build();
		}
	}
}
