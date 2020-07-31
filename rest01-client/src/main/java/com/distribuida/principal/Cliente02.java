package com.distribuida.principal;

import java.net.URL;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

//Cliente JAX-RS normal
public class Cliente02 {
	public static final String URL = "http://localhost:8080/rest01";

	public static void main(String[] args) {
		Client cliente = ClientBuilder.newClient();
		WebTarget target = cliente.target(URL).path("/personas/{id}").resolveTemplate("id", 2);
		Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
		try {
			Persona per = builder.get(Persona.class);
			System.out.println("nombre: " + per.getNombre());
			System.out.println("mensaje: " + per.getMensaje());
		} catch (NotFoundException e) {
			System.out.println("Estado"+e.getResponse().getStatus());
			System.out.println("Entity"+e.getResponse().getStatusInfo());
		}

	}

}
