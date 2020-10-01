package com.distribuida.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
@ApplicationScoped
@Path("/ping")
public class PingRest {
	@GET
	public String ping() {
		System.out.println("ping");
		return "ok";
	}
}
