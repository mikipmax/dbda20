package com.distribuida.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import com.distribuida.dto.Persona;
import com.distribuida.servlets.EmLoaderListener;

@ApplicationScoped
public class ServicioPersonaImpl implements ServicioPersonaI {

	@Inject
	private EntityManager em;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listar() {

		return em.createNamedQuery("Persona.findAll").getResultList();
		
	}

	@Override
	public Persona buscarId(int id) {
		return em.find(Persona.class, id);
	}

	@Override
	public void crear(Persona per) {
		em.getTransaction().begin();
		em.persist(per);
		em.getTransaction().commit();
	}

	@Override
	public void actualizar(int id,Persona per) {
		per.setId(id);
		em.getTransaction().begin();
		em.merge(per);
		em.getTransaction().commit();
	}

	@Override
	public void eliminar(int id) {
		em.getTransaction().begin();
		em.remove(buscarId(id));
		em.getTransaction().commit();
	}
	


}
