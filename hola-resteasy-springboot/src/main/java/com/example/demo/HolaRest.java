package com.example.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;



@Component
@Path("/hola")
public class HolaRest {
	@GET
	
	@Produces(MediaType.APPLICATION_JSON)
	public String hola() {
		return "Hola Mundo";
	}
}
