package com.distribuida.proxies;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Posts;
import com.distribuida.dto.Usuario;

public interface UsuarioProxy {
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Usuario> listar();

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{id}")
	public Usuario buscar(@PathParam("id") int id);
}
