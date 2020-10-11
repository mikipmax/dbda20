package com.distribuida.restclient;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.distribuida.dto.Customer;
import com.distribuida.dto.Orders;
import com.distribuida.proxies.CustomerProxy;
import com.distribuida.proxies.OrdersProxy;
@ApplicationScoped
@Path("/")
public class Rest {

	@Inject
	private CustomerProxy servicioCustomer;
	@Inject
	OrdersProxy servicioOrders;

	@GET
	@Path("customers")
	public List<Customer> hello() {
		System.out.println(servicioCustomer.lista().get(0).getSurname());
		return servicioCustomer.lista();
	}

//	@GET
//	@Path("orders")
//	public List<Orders> hello1() {
//		return servicioOrders.lista();
//	}

}
