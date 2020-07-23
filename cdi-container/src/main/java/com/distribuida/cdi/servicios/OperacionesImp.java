package com.distribuida.cdi.servicios;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named() // Le pone por default el nombre de la clase pero la primera letra con minuscula
			// es decir: operacionesImp

@ApplicationScoped
public class OperacionesImp implements Operaciones {

	@Override
	public int sumar(int a, int b) {

		return a + b;
	}

}
