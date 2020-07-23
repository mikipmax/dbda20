package com.distribuida.cdi.servicios;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.distribuida.qualifier.MiBeanL;
import com.distribuida.qualifier.MiBeanL2;
@ApplicationScoped
public class OperacionesProducer {
	//Notemos que tenemos dos método productores que retornan el mismo tipo de interfaz
	//Entonces tenemos ambguiedad es por esa razón que se aniaden los qualifier.
	@Produces @ApplicationScoped
	@MiBeanL
	public Operaciones create() {
		System.out.println("MiBean1");
		return new OperacionesImp();
	}
	
	@Produces @ApplicationScoped
	@MiBeanL2
	public Operaciones create1() {
	System.out.println("MiBean2");
		return new OperacionesImp();
	}
}
