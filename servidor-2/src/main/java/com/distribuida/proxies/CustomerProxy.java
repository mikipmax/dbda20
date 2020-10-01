package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Customer;

public interface CustomerProxy {
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/bl")
	public String comprobarBalanceoS1();
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Customer> listar();

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{id}")
	public Customer buscar(@PathParam("id") int id);
}
