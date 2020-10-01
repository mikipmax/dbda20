package com.distribuida.proxies;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
@ApplicationScoped
public class ProducerPersonaProxy {
	public static final String URL = "https://ponce-distribuida02.herokuapp.com/personas"; 
	//public static final String URL="http://localhost:8080/rest02-crud-jdbc/personas"; //local
	@ApplicationScoped @Produces
	public PersonaProxy produceProxy() {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = cliente.target(URL);
		return target.proxy(PersonaProxy.class);
	}
}
