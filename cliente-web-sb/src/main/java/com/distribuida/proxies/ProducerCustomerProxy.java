package com.distribuida.proxies;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@ApplicationScoped
public class ProducerCustomerProxy {
	public static final String URL_SERV1 = "http://localhost:8090/microservicio/customers";
	public static final String URL_SERV2 = "http://localhost:8090/microservicio/orders";
											
//	public static final String URL_SERV1 = "https://ponce-distribuida41.herokuapp.com/customers";
//	public static final String URL_SERV2 = "https://ponce-distribuida42.herokuapp.com/orders";
	ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();

	@ApplicationScoped
	@Produces
	public CustomerProxy produceProxyCustomer() {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = cliente.target(URL_SERV1);
		return target.proxy(CustomerProxy.class);
	}

	@ApplicationScoped
	@Produces

	public OrdersProxy produceProxyOrders() {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();

		ResteasyWebTarget target = cliente.target(URL_SERV2);
		return target.proxy(OrdersProxy.class);
	}
}
