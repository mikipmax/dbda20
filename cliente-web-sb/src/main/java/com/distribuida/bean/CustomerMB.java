package com.distribuida.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.dto.Customer;
import com.distribuida.proxies.CustomerProxy;
import com.distribuida.utileria.Mensajes;

@SessionScoped

@Named("customerBean")
public class CustomerMB extends Mensajes implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private CustomerProxy customerServicio;
	private Customer customer;
	private Customer customerSeleccionado;
	private List<Customer> lista;

	@PostConstruct
	public void init() {
		customer = new Customer();
		customerSeleccionado = new Customer();
		listar();
	}

	public void listar() {
		try {
			lista = customerServicio.lista();
		} catch (Exception e) {
			mensajeError("Error: " + e.getMessage());
		}

	}

	public void crear() {
		try {
			customerServicio.crear(customer);
			mensajeInfo("Registro creado correctamente");
		} catch (Exception e) {
			mensajeError("Error: " + e.getMessage());
		} finally {
			customer = new Customer();
			listar();
		}
	}

	public void actualizar() {
		try {
			customerServicio.actualizar(customerSeleccionado.getId(), customerSeleccionado);
			mensajeInfo("Registro actualizado correctamente");
		} catch (Exception e) {
			mensajeError("Error: " + e.getMessage());
		} finally {
			customerSeleccionado = new Customer();
			listar();
		}

	}

	public void eliminar(Customer customer) {
		try {
			customerServicio.eliminar(customer.getId());
			mensajeInfo("Registro eliminado correctamente");
		} catch (Exception e) {
			mensajeError("Error: No se puede eliminar este registro ya que es foránea en orders");

		} finally {
			customer = new Customer();
			listar();
		}

	}

	public void filaSeleccionada(Customer customer) {
System.out.println("********************");
		customerSeleccionado = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getLista() {
		return lista;
	}

	public void setLista(List<Customer> lista) {
		this.lista = lista;
	}

	public Customer getCustomerSeleccionado() {
		return customerSeleccionado;
	}

	public void setCustomerSeleccionado(Customer customerSeleccionado) {
		this.customerSeleccionado = customerSeleccionado;
	}

}
