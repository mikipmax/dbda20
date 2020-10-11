package com.distribuida.servicios;

import java.util.List;

import com.distribuida.dto.Posts;

public interface PostsServicioI {
	List<Posts> listar();

	Posts buscar(int id);

}
