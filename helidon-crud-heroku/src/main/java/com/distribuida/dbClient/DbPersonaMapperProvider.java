package com.distribuida.dbClient;

import java.util.Optional;



import com.distribuida.clases.Persona;

import io.helidon.dbclient.DbMapper;
import io.helidon.dbclient.spi.DbMapperProvider;

/**
 * Clase que me devuelve un objeto de tipo DbMapper<Persona>, el cuál me permite asociarlo
 * con el objeto DbClient a través del método mapperProvider, está clase a su vez hace uso de DbRecordMapper, que es
 * la que hace las conversiones de objetos DbRow a Persona
 */
public class DbPersonaMapperProvider implements DbMapperProvider {
	private static final DbMapper<Persona> MAPPER = new DbPersonaMapper();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Optional<DbMapper<T>> mapper(Class<T> aClass) {
		if (Persona.class.equals(aClass)) {
			return Optional.of((DbMapper<T>) MAPPER);
		}
		return Optional.empty();
	}
}
