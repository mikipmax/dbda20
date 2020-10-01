package com.distribuida.servicios;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.transaction.Transactional;

import com.distribuida.dto.Usuario;

@ApplicationScoped
@Transactional
public class UsuarioServicioImpl implements UsuarioServicioI {

	@Inject
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {

		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	@Override
	public Usuario buscarId(int id) {

		return em.find(Usuario.class, id);
	}

	@Override
	public void crear(Usuario customer) {

		em.persist(customer);

	}

	@Override
	public void editar(int id, Usuario customer) {

		customer.setId(id);

		em.merge(customer);

	}

	@Override
	public void eliminar(int id) {

		em.remove(buscarId(id));

	}

}
