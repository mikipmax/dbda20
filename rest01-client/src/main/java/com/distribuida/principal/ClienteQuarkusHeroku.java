package com.distribuida.principal;

import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class ClienteQuarkusHeroku {
//Cliente RESTEasy
	public static final String URL = "https://ponce-distribuida42.herokuapp.com/orders";

	public static void main(String[] args) {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = cliente.target(URL);
		OrdersProxy service = target.proxy(OrdersProxy.class);
		int i = 1;
		while (true) {
			try {
				System.out.println("Consumiento servicio " + i++);
				Thread.sleep(24 * 60 * 1000L);
				service.lista().forEach(o -> System.out.println(o.item));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
