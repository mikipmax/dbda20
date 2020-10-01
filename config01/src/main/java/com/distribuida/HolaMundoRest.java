package com.distribuida;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@ApplicationScoped
@Path("/hola")
public class HolaMundoRest {
	//@Inject private Config config;
	@Inject
	@ConfigProperty(name = "helidonTest/texto", defaultValue = "asf") private String msg;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String hola() {
		
		//Config config= ConfigProvider.getConfig(); //dejamos q cdi lo gestione
		//listar las fuentes de configuracion
		//config.getConfigSources().forEach(s->System.out.println(s.getName()));
		//Integer puerto=config.getValue("server.port", Integer.class);
		//System.out.println(puerto);
		//String texto=config.getValue("texto", String.class);
		return msg;
	}
}
