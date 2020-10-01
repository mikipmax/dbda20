package com.distribuida.proxies;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@ApplicationScoped
public class ProducerCommentsProxy {
	//apunto al gateway
	public static final String URL = "http://localhost:8090/tipoDirecciones";

	@ApplicationScoped
	@Produces
	public TipoDireccionProxy produceProxy() {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = cliente.target(URL);
		return target.proxy(TipoDireccionProxy.class);
	}

}
