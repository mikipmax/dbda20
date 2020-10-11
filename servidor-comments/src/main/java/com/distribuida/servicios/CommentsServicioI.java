package com.distribuida.servicios;

import java.util.List;

import com.distribuida.dto.Comments;

public interface CommentsServicioI {
	List<Comments> listar();

	Comments buscar(int id);

}
