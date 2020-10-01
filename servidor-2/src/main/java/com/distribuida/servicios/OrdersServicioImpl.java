package com.distribuida.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.distribuida.dto.Orders;
import com.distribuida.proxies.CustomerProxy;
import com.distribuida.repositorios.OrdersRepositorio;

@Component
public class OrdersServicioImpl implements OrdersServicioI {

	@Autowired
	private OrdersRepositorio ordersServicio;
	@Autowired
	private CustomerProxy customerServicio;
	@Value("${config.balanceador.test}")
	private String bl;

	@Override
	public List<Orders> listar() {
		List<Orders> lista = (List<Orders>) ordersServicio.findAll();
		List<Orders> listaAux = new ArrayList<>();
		for (Orders orders : lista) {

			orders.setCustomer(customerServicio.buscar(orders.getCustomerId()));
			listaAux.add(orders);
		}
		return listaAux;
	}

	@Override
	public Orders buscarId(int id) {

		Optional<Orders> orders = ordersServicio.findById(id);
		if (orders.isPresent()) {
			Orders ordersAux = orders.get();
			// ordersAux.setCustomer(customerServicio.buscar(ordersAux.getCustomerId()));
			return ordersAux;
		}
		return null;
	}

	@Override
	public void crear(Orders orders) {
		ordersServicio.save(orders);

	}

	@Override
	public void editar(int id, Orders orders) {
		orders.setId(id);
		ordersServicio.save(orders);

	}

	@Override
	public void eliminar(int id) {
		ordersServicio.deleteById(id);

	}

	@Override
	public String comprobarBalanceoS2() {
		return "Serv1: " + customerServicio.comprobarBalanceoS1() + ", Serv2: " + bl;
	}

}
