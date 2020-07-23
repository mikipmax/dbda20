package com.distribuida.cdi.principal;

import javax.enterprise.inject.Instance;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import com.distribuida.cdi.servicios.Operaciones;
import com.distribuida.qualifier.MiBeanL;
import com.distribuida.qualifier.MiBeanL2;

//Este main hace uso de un qualifier al momento de hacer la inyección mediante Produces
public class Principal2 {
	public static void main(String[] args) {
		// Inicializamos el contenedor
		SeContainer container = SeContainerInitializer.newInstance().initialize();
		// lookup, buscamos objeto de tipo Operaciones
		Instance<Operaciones> obj = container.select(Operaciones.class, MiBeanL2.Literal.INSTANCE); //Paso como 2do parámetro el qualifier creado
		Operaciones servicio = obj.get();
		// invocamos al método del servicio
		System.out.println("Respuesta: " + servicio.sumar(5, 12));

	}

}
