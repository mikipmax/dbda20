package com.distribuida.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.distribuida.dto.Customer;
import com.distribuida.servicios.CustomerServicioI;

@Component
@Path("/")
public class RestCustomer {

	@Autowired
	private CustomerServicioI servicioPersonaI;

	@GET
	@Path("/bl")
	@Produces(MediaType.APPLICATION_JSON)
	public String comprobarBalanceo() {
		return servicioPersonaI.comprobarBalanceo();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> listar() {
		return servicioPersonaI.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer buscarId(@PathParam("id") int id) {
		return servicioPersonaI.buscarId(id);
	}

	@POST
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crear(Customer per) {
		servicioPersonaI.crear(per);
	}

	@PUT
	@Path("/actualizar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(@PathParam("id") int id, Customer per) {
		servicioPersonaI.editar(id, per);
	}

	@DELETE
	@Path("/eliminar/{id}")
	public void eliminar(@PathParam("id") int id) {
		servicioPersonaI.eliminar(id);
	}
}
