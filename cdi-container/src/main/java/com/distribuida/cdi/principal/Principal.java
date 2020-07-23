package com.distribuida.cdi.principal;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.literal.NamedLiteral;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import com.distribuida.cdi.servicios.Operaciones;

public class Principal {
	public static void main(String[] args) {
		// Inicializamos el contenedor
		SeContainer container = SeContainerInitializer.newInstance().initialize();
		// lookup, buscamos objeto de tipo Operaciones
		Instance<Operaciones> obj = container.select(Operaciones.class, NamedLiteral.of("operacionesImp"));
		Operaciones servicio = obj.get();
		// invocamos al método del servicio
		System.out.println("Respuesta: " + servicio.sumar(5, 12));
		
	}

}
