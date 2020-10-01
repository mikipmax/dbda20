package com.distribuida.proxies;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@ApplicationScoped
public class ProducerCostumerProxy {
	public static final String URL = "https://jsonplaceholder.typicode.com/posts";
	public static final String URL1 = "http://localhost:8081/usuarios";

	@ApplicationScoped
	@Produces
	public PostsProxy produceProxy() {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = cliente.target(URL);
		return target.proxy(PostsProxy.class);
	}
	@ApplicationScoped
	@Produces
	public UsuarioProxy produceProxy1() {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = cliente.target(URL1);
		return target.proxy(UsuarioProxy.class);
	}
}
