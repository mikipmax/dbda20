package com.distribuida.servicios;

import java.util.List;

import com.distribuida.dto.Orders;

public interface OrdersServicioI {
	List<Orders> listar();

	Orders buscarId(int id);

	void crear(Orders Orders);

	void editar(int id, Orders Orders);

	void eliminar(int id);
	
	String comprobarBalanceoS2();
}
