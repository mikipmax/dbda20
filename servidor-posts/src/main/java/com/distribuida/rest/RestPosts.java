package com.distribuida.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Posts;

import com.distribuida.servicios.PostsServicioI;

@ApplicationScoped
@Path("/posts")
public class RestPosts {

	@Inject
	private PostsServicioI servicioPosts;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Posts> listar() {
		List<Posts> lista = servicioPosts.listar();

		return lista;

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Posts buscarId(@PathParam("id") int id) {
		Posts posts = servicioPosts.buscar(id);

		return posts;
	}

}
