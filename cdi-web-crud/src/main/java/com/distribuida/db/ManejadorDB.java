package com.distribuida.db;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

@ApplicationScoped
public class ManejadorDB {
	/**
	 * Método productor, para manejar pool de conexiones
	 * 
	 * @return Datasource
	 */
	@Produces
	@ApplicationScoped
	public DataSource db() {

		BasicDataSource ds = new BasicDataSource();

		URI dbUri;

		try {
			//dbUri = new URI(System.getenv("DATABASE_URL")); //publica
			// Local
			dbUri = new URI(
					"postgres://susrihwvtdlufj:2febe9504e86bb183a698a66ed45cfdc79c284b13337bb462d874138febb4069@ec2-54-236-169-55.compute-1.amazonaws.com:5432/d5drrsk51olgq5");
			System.out.println("dbUri");
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath()
					+ "?sslmode=require";

			ds.setDriverClassName("org.postgresql.Driver");
			ds.setUrl(dbUrl);
			System.out.println(dbUrl); 
			System.out.println(username); 
			System.out.println(password); 
			ds.setUsername(username);
			ds.setPassword(password);
		} catch (URISyntaxException e) {
			e.printStackTrace();

			throw new RuntimeException("no s epuede conectar a la base de datos");
		}

//        ds.setDriverClassName( "org.postgresql.Driver" );
//        ds.setUrl( "jdbc:postgresql://127.0.0.1:5432/distribuida" );
//        ds.setUsername( "postgres" );
//        ds.setPassword( "postgres" );

		return ds;
	}

}
