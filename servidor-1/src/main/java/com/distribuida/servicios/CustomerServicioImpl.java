package com.distribuida.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.distribuida.dto.Customer;
import com.distribuida.repositorios.CustomerRepositorio;

@Component
public class CustomerServicioImpl implements CustomerServicioI {

	@Autowired
	private CustomerRepositorio customerServicio;
	@Value("${config.balanceador.test}")
	private String bl;

	@Override
	public List<Customer> listar() {

		return (List<Customer>) customerServicio.findAll();
	}

	@Override
	public Customer buscarId(int id) {
		Optional<Customer> customer = customerServicio.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		}
		return null;
	}

	@Override
	public void crear(Customer customer) {
		customerServicio.save(customer);

	}

	@Override
	public void editar(int id, Customer customer) {
		customer.setId(id);
		customerServicio.save(customer);

	}

	@Override
	public void eliminar(int id) {
		customerServicio.deleteById(id);

	}

	@Override
	public String comprobarBalanceo() {

		return bl;
	}

}
