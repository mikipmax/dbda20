package com.distribuida.dbClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import io.helidon.config.Config;
import io.helidon.dbclient.DbClient;

@ApplicationScoped
public class DbClientProducer {
	@Produces
	@ApplicationScoped
	public DbClient db() {

		Config dbConfig = Config.create().get("db"); // Obtengo la configuración(cadena de conexión) desde application.yaml
		DbClient dbClient = DbClient.builder(dbConfig)
				.mapperProvider(new DbPersonaMapperProvider()) //Le indico un provedor de mapeo que me convierta de DbRow a Persona
				
				.build();
		return dbClient;
	}
}
