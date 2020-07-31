package com.distribuida.principal;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface HolaMundoService {
	@GET
	@Path("/personas")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Persona> hola();
	
}
