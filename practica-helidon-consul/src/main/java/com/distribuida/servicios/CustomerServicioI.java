package com.distribuida.servicios;

import java.util.List;

import com.distribuida.dto.Customer;

public interface CustomerServicioI {
	List<Customer> listar();

	Customer buscarId(int id);

	void crear(Customer customer);

	void editar(int id, Customer customer);

	void eliminar(int id);

}
