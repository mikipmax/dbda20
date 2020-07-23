package com.distribuida.servicios;

import java.util.List;

import com.distribuida.dto.Direccion;

public interface ServicioDireccionI {

	List<Direccion> listar();

	Direccion buscarId(Direccion direccion );

	void crear(Direccion direccion);

	void editar(Direccion direccion);

	void eliminar(Direccion direccion);
}
