package com.distribuida.dbClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.distribuida.clases.Persona;

import io.helidon.dbclient.DbColumn;
import io.helidon.dbclient.DbMapper;
import io.helidon.dbclient.DbRow;

public class DbPersonaMapper implements DbMapper<Persona> {
	/**
	 * Sobreescribo el método, esté me sirve para convertir un DbRow en una Persona
	 * y así poder listarlas en mi servicio.
	 * 
	 */
	@Override
	public Persona read(DbRow dbRow) {
		DbColumn id = dbRow.column("id");
		DbColumn nombre = dbRow.column("nombre");
		DbColumn direccion = dbRow.column("direccion");
		DbColumn correo = dbRow.column("correo");
		return new Persona(id.as(Integer.class), nombre.as(String.class), direccion.as(String.class),
				correo.as(String.class));
	}

	/**
	 * Sobreescribo esté método para poder mapear los json en persona, y así poder
	 * crear, y actualizar una personas
	 */
	@Override
	public Map<String, Object> toNamedParameters(Persona value) {
		Map<String, Object> map = new HashMap<>(2);
		map.put("id", value.getId());
		map.put("nombre", value.getNombre());
		map.put("direccion", value.getDireccion());
		map.put("correo", value.getCorreo());
		return map;
	}

	// En mi caso no necesito implementarlo ya que no voy a usar indexedParam
	@Override
	public List<?> toIndexedParameters(Persona value) {
		return null;
	}

}
