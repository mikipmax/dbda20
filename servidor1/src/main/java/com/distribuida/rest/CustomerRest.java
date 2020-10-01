package com.distribuida.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.distribuida.dto.Customer;

@ApplicationScoped
@Path("/customers")
public class CustomerRest {

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Customer> listar() {
		return Customer.listAll();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{id}")
	public Customer buscar(@PathParam("id") int id) {
		return Customer.find("id", id).firstResult();
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("/crear")
	@Transactional
	public void crear(Customer customer) {
		Customer.persist(customer);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("/actualizar/{id}")
	@Transactional
	public void actualizar(@PathParam("id") int id, Customer customer) {
		Customer.update("name=?1, surname=?2 where id=?3", customer.name, customer.surname, id);
	}

	@DELETE
	@Path("eliminar/{id}")
	@Transactional
	public void eliminar(@PathParam("id") int id) {
		Customer.delete("id", id);
	}

}
