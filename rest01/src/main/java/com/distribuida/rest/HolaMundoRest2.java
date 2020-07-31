package com.distribuida.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hola")
public class HolaMundoRest2 {
	// http://servidor:puerto/contexto/PATH/hola/{nombre}
	// uri efectivo: http://localhost:8080/rest01/hola/{nombre}
	@GET
	@Path(value = "/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Persona hola(@PathParam("nombre") String nombre) {

		return new Persona(nombre, "Hola ");
	}
}
