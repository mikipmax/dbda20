package com.distribuida.rest;

import java.util.ArrayList;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.agent.model.NewService;

@ApplicationScoped
@ApplicationPath("/")
public class RestApplication extends Application {
	@Inject
	@ConfigProperty(name = "server.port", defaultValue = "8091")
	private Integer port;

	// Método que escucha cuando la aplicación inicia
	// mediante el contexto de aplicationScoped
	public void init(@Observes @Initialized(ApplicationScoped.class) Object event) {
		System.out.println("init");
		// hay que registrar la ip y puerto
		// http://ip:puerto/xxxx
		ConsulClient client = new ConsulClient();
		NewService newService = new NewService();
		newService.setId("customer-service-" + port);// instancia, debe ser único
		newService.setName("customer-service");// nombre del servicio
		newService.setPort(port);// puerto del servico
		newService.setAddress("127.0.0.1");// ip del servicio
		List<String> lista = new ArrayList<>();
		lista.add("urlprefix-/customers");
		newService.setTags(lista);
		// Para hacer ping con el servicio
		// Registrar el URL para verificar si el servidor está activo o no
		NewService.Check serviceCheck = new NewService.Check();
		serviceCheck.setMethod("GET");
		serviceCheck.setHttp("http://127.0.0.1:" + port + "/ping");
		serviceCheck.setInterval("10s");
		serviceCheck.setDeregisterCriticalServiceAfter("20s");
		newService.setCheck(serviceCheck);
		client.agentServiceRegister(newService);
	}

	// Mëtodo que escucha cuando la aplicación se destruye
	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object event) {
		System.out.println("destroy");

		ConsulClient client = new ConsulClient();
		client.agentServiceDeregister("customer-service-" + port);
	}
}
