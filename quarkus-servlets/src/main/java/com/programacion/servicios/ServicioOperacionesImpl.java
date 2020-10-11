package com.programacion.servicios;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicioOperacionesImpl implements ServicioOperaciones {

	@Override
	public int sumar(int a, int b) {
		
		return a+b;
	}

}
