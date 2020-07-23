package com.distribuida.db;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

@ApplicationScoped
public class ManejadorDb {
	@Produces @ApplicationScoped
	public DataSource db() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost:5432/distribuida");
		ds.setUsername("postgres");
		ds.setPassword("admin");
		ds.setMaxTotal(10);
		ds.setMaxIdle(5); //Empieza con 5 conexiones y va subiendo hasta 10
		return ds;
	}
}
