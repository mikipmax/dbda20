package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.distribuida.dto.Customer;

@ApplicationScoped
@Transactional
public class CustomerServicioImpl implements CustomerServicioI {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listar() {

		return em.createNamedQuery("Customer.findAll").getResultList();
	}

	@Override
	public Customer buscarId(int id) {

		return em.find(Customer.class, id);
	}

	@Override
	public void crear(Customer customer) {

		em.persist(customer);

	}

	@Override
	public void editar(int id, Customer customer) {

		customer.setId(id);

		em.merge(customer);

	}

	@Override
	public void eliminar(int id) {

		em.remove(buscarId(id));

	}

}
