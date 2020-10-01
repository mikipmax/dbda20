package com.distribuida.test;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.literal.NamedLiteral;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import com.distribuida.proxies.OrdersProxy;

public class Principal {
	public static void main(String[] args) {
		// Inicializamos el contenedor
		SeContainer container = SeContainerInitializer.newInstance().initialize();
		// lookup, buscamos objeto de tipo Operaciones
		Instance<OrdersProxy> obj = container.select(OrdersProxy.class, NamedLiteral.of("test"));
		OrdersProxy servicio = obj.get();
		// invocamos al método del servicio
		servicio.lista().forEach(o -> System.out.println(o.item));

	}

}
