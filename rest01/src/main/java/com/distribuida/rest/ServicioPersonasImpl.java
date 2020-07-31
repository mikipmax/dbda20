package com.distribuida.rest;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicioPersonasImpl implements ServicioPersonas {
	private List<Persona> lista;

	@PostConstruct
	public void inicializar() {
		lista = new ArrayList<>();
		lista.add(new Persona(1, "nombre1"));
		lista.add(new Persona(2, "nombre2"));
		lista.add(new Persona(3, "nombre3"));
		lista.add(new Persona(4, "nombre4"));
		lista.add(new Persona(5, "nombre5"));
	}

	@Override
	public List<Persona> listar() {
		
		return lista;
	}

	@Override
	public Persona buscar(Integer id) {
		List<Persona> ret = lista.stream().filter(s -> s.getId().equals(id)).collect(Collectors.toList());
		if (ret.isEmpty()) {
			return null;
		}
		return ret.get(0);
	}

}
