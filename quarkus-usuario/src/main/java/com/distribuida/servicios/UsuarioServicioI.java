package com.distribuida.servicios;

import java.util.List;


import com.distribuida.dto.Usuario;

public interface UsuarioServicioI {
	List<Usuario> listar();

	Usuario buscarId(int id);

	void crear(Usuario customer);

	void editar(int id, Usuario customer);

	void eliminar(int id);

}
