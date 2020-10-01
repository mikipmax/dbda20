package com.distribuida.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.clases.Persona;

import io.helidon.common.reactive.Multi;

import io.helidon.dbclient.DbClient;

@ApplicationScoped
public class PersonaServicioImpl implements PersonaServicioI {

	@Inject
	DbClient dbClient;

	List<Persona> lista1 = new ArrayList<>();

	@Override
	public List<Persona> listar() {
		List<Persona> lista = new ArrayList<>();

		try {

			Multi<Persona> multiPersona = dbClient.execute(exec -> exec.namedQuery("select-personas"))
					.map(it -> it.as(Persona.class));
			// Convierto Multi<Persona> a List<Persona>
			lista = multiPersona.collectList().get();

		} catch (Exception e) {

			e.printStackTrace(System.out);
		}

		return lista;
	}

	@Override
	public Persona buscarId(int id) {
		Persona per = null;
		try {

			Multi<Persona> multiPersona = dbClient
					.execute(exec -> exec.createNamedQuery("select-persona-id").addParam("id", id).execute())
					.map(ex -> ex.as(Persona.class));
			per = multiPersona.collectList().get().get(0); // obtengo el primero
		} catch (Exception e) {

			e.printStackTrace(System.out);
		}
		return per;
	}

	@Override
	public void crear(Persona per) {
		dbClient.inTransaction(tx -> tx.createNamedInsert("insert-persona").namedParam(per).execute());

	}

	@Override
	public void editar(int id, Persona per) {
		per.setId(id);
		dbClient.inTransaction(tx -> tx.createNamedUpdate("update-persona").namedParam(per).execute());

	}

	@Override
	public void eliminar(int id) {
		dbClient.inTransaction(tx -> tx.createNamedUpdate("delete-persona").addParam("id", id).execute());
	}

}
