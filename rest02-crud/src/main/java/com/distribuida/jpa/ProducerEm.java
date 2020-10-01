package com.distribuida.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.distribuida.servlets.EmLoaderListener;

@ApplicationScoped
public class ProducerEm {

	EntityManagerFactory emf = EmLoaderListener.getEmf();

	@ApplicationScoped
	@Produces
	public EntityManager crearEm() {
		return emf.createEntityManager();
	}
}
