package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.distribuida.dto.TipoDireccion;

@ApplicationScoped
@Path("/tipoDirecciones")
public class CustomerRest {

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<TipoDireccion> listar() {
		return TipoDireccion.listAll();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{id}")
	public TipoDireccion buscar(@PathParam("id") int id) {
		return TipoDireccion.find("id", id).firstResult();
	}



}
