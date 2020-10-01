package com.distribuida.rest;

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




import com.distribuida.dto.Usuario;
import com.distribuida.servicios.UsuarioServicioI;

@ApplicationScoped
@Path("/usuarios")
public class RestUsuario {

	@Inject
	private UsuarioServicioI servicioPersonaI;



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar() {
		return servicioPersonaI.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario buscarId(@PathParam("id") int id) {
		return servicioPersonaI.buscarId(id);
	}

	@POST
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	public void crear(Usuario per) {
		servicioPersonaI.crear(per);
	}

	@PUT
	@Path("/actualizar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(@PathParam("id") int id, Usuario per) {
		servicioPersonaI.editar(id, per);
	}

	@DELETE
	@Path("/eliminar/{id}")
	public void eliminar(@PathParam("id") int id) {
		servicioPersonaI.eliminar(id);
	}
}
