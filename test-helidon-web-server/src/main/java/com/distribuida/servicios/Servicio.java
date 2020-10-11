package com.distribuida.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import com.distribuida.dto.TipoDireccion;
import com.distribuida.proxies.TipoDireccionProxy;

import io.helidon.webserver.Routing.Rules;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;


public class Servicio implements Service {
	@Inject
	private TipoDireccionProxy serv;

	@Override
	public void update(Rules rules) {
		rules.get("/td", this::personas);

	}

	private void personas(ServerRequest serverRequest, ServerResponse serverResponse) {
		//List<TipoDireccion> lista1=serv.listar();
		List<TipoDireccion> lista = new ArrayList<>();
		lista.add(new TipoDireccion(55, "TEST"));
		JsonArray jsonArray = from(lista);

		serverResponse.send(jsonArray);
	}

	private JsonArray from(List<TipoDireccion> books) {
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		books.forEach(book -> {
			jsonArrayBuilder.add(from(book));
		});
		return jsonArrayBuilder.build();
	}

	private JsonObject from(TipoDireccion tipoDireccion) {
		JsonObject jsonObject = Json.createObjectBuilder().add("id", tipoDireccion.getId())
				.add("descripcion", tipoDireccion.getDescripcion())

				.build();
		return jsonObject;
	}
}
