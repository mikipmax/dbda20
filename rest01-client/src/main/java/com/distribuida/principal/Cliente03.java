package com.distribuida.principal;

import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class Cliente03 {
//Cliente RESTEasy
	public static final String URL = "http://localhost:9090/rest01";

	public static void main(String[] args) {
		ResteasyClient cliente = (ResteasyClient) ClientBuilder.newClient();
		ResteasyWebTarget target = cliente.target(URL);
		HolaMundoService service = target.proxy(HolaMundoService.class);
		
		//Persona per=service.hola();
		
	//	System.out.println("nombre: " + per.getNombre());
		//System.out.println("mensaje: "+per.getMensaje());
	}

}
