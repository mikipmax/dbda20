package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Comments;

public interface CommentsProxy {
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Comments> listar();

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{id}")
	public Comments buscar(@PathParam("id") int id);
}
