package com.distribuida.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.dto.Customer;
import com.distribuida.dto.Orders;
import com.distribuida.proxies.CustomerProxy;
import com.distribuida.proxies.OrdersProxy;
import com.distribuida.utileria.Mensajes;

@SessionScoped
@Named("ordersBean")
public class OrdersMB extends Mensajes implements Serializable {

	private static final long serialVersionUID = 1L;
	private Orders orders;
	private Orders ordersSeleccionado;

	private Customer customer;

	private List<Orders> lista;
	private List<Customer> listaCustomers;
	@Inject
	private OrdersProxy ordersServicio;
	@Inject
	private CustomerProxy customerServicio;

	@PostConstruct
	public void init() {
		orders = new Orders();
		ordersSeleccionado = new Orders();
		customer = new Customer();

		listar();
		setListaCustomers(customerServicio.lista());
	}

	public void listar() {
		try {
			lista = ordersServicio.lista();
		} catch (Exception e) {
			mensajeError("Error: " + e.getMessage());
		}

	}

	public void crear() {
		try {

			orders.setCustomerId(customer.getId());
			ordersServicio.crear(orders);
			mensajeInfo("Registro creado correctamente");
		} catch (Exception e) {
			mensajeError("Error: " + e.getMessage());
		} finally {
			orders = new Orders();
			listar();
		}
	}

	public void actualizar() {
		try {
			System.out.println(ordersSeleccionado.getCustomerId() + "----------------");
			ordersServicio.actualizar(ordersSeleccionado.getId(), ordersSeleccionado);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("Error: " + e.getMessage());
		} finally {
			ordersSeleccionado = new Orders();

			listar();
		}

	}

	public void eliminar(Orders orders) {
		try {
			ordersServicio.eliminar(orders.getId());
			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("Error: " + e.getMessage());
		} finally {

			orders = new Orders();
			listar();
		}
	}

	public void filaSeleccionada(Orders orders) {
		ordersSeleccionado = orders;

	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Orders getOrdersSeleccionado() {
		return ordersSeleccionado;
	}

	public void setOrdersSeleccionado(Orders ordersSeleccionado) {
		this.ordersSeleccionado = ordersSeleccionado;
	}

	public List<Orders> getLista() {
		return lista;
	}

	public void setLista(List<Orders> lista) {
		this.lista = lista;
	}

	public List<Customer> getListaCustomers() {
		return listaCustomers;
	}

	public void setListaCustomers(List<Customer> listaCustomers) {
		this.listaCustomers = listaCustomers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
