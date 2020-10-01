package com.distribuida.rest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
import com.distribuida.dto.Orders;
import com.distribuida.proxies.CustomerProxy;

@ApplicationScoped
@Path("/orders")
public class OrdersRest {
	@Inject
	CustomerProxy customerServicio;

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Orders> listar() {

		List<Orders> lista = Orders.listAll();
		List<Orders> listaAux = new ArrayList<>();
		for (Orders orders : lista) {

			orders.customer = customerServicio.buscar(orders.customerId);
			listaAux.add(orders);
		}
		return listaAux;
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{id}")
	public Orders buscar(@PathParam("id") int id) {
		Orders orders = Orders.find("id", id).firstResult();
		orders.customer = customerServicio.buscar(orders.customerId);
		return orders;
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("/crear")
	@Transactional
	public void crear(Orders orders) {

		Orders.persist(orders);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("/actualizar/{id}")
	@Transactional
	public void actualizar(@PathParam("id") int id, Orders orders) {
		Orders.update("item=?1, price=?2, customerId=?3 where id=?4", orders.item, orders.price,orders.customerId, id);
	}

	@DELETE
	@Path("eliminar/{id}")
	@Transactional
	public void eliminar(@PathParam("id") int id) {
		Orders.delete("id", id);
	}

}
