package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Comments;
import com.distribuida.dto.Posts;

public interface PostsProxy {
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Posts> listar();

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{id}")
	public Posts buscar(@PathParam("id") int id);
}
