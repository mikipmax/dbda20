package com.distribuida.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import com.distribuida.dto.Persona;
import com.distribuida.proxies.TipoDireccionProxy;

@ApplicationScoped
@Transactional
public class PersonaServicioImpl implements PersonaServicioI {

	@PersistenceContext
	private EntityManager em;
	@Inject
	TipoDireccionProxy servicioTipoDireccion;

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listar() {
		List<Persona> lista = em.createNamedQuery("Persona.findAll").getResultList();
		List<Persona> listaAux = new ArrayList<>();
		for (Persona persona : lista) {

			persona.setTipoDireccionE(servicioTipoDireccion.buscar(persona.getTipoDireccion()));
			listaAux.add(persona);
		}
		return listaAux;

	}

	@Override
	public Persona buscarId(int id) {
		Persona persona=em.find(Persona.class, id);
		persona.setTipoDireccionE(servicioTipoDireccion.buscar(persona.getTipoDireccion()));
		return persona;
	}

}
