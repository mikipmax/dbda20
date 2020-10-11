package com.distribuida.rest;

import java.util.ArrayList;
import java.util.List;

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

import com.distribuida.dto.Comments;
import com.distribuida.dto.Posts;
import com.distribuida.proxies.CommentsProxy;
import com.distribuida.proxies.PostsProxy;

@ApplicationScoped
@Path("/comments")
public class RestUsuario {

	@Inject
	private CommentsProxy servicioComments;
	@Inject
	private PostsProxy servicioPosts;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comments> listar() {
		List<Comments> lista = servicioComments.listar();
		List<Comments> listaAux = new ArrayList<>();
		for (Comments comments : lista) {

			comments.setPosts(servicioPosts.buscar(comments.getPostId()));
			listaAux.add(comments);
		}
		return listaAux;

	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comments buscarId(@PathParam("id") int id) {
		return servicioComments.buscar(id);
	}

}
