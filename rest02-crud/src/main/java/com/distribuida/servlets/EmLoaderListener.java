package com.distribuida.servlets;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.net.URI;

import java.util.HashMap;
import java.util.Map;

@WebListener
public class EmLoaderListener implements ServletContextListener {

	private static EntityManagerFactory emf;

	@Override
	public void contextInitialized(ServletContextEvent event) {

		URI dbUri;
		try {
			dbUri = new URI(
					"postgres://susrihwvtdlufj:2febe9504e86bb183a698a66ed45cfdc79c284b13337bb462d874138febb4069@ec2-54-236-169-55.compute-1.amazonaws.com:5432/d5drrsk51olgq5"); //local
			//dbUri = new URI(System.getenv("DATABASE_URL")); //publica
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath()
					+ "?sslmode=require";
			Map<String, String> properties = new HashMap<String, String>();

			properties.put("javax.persistence.jdbc.url", dbUrl);
			properties.put("javax.persistence.jdbc.user", username);
			properties.put("javax.persistence.jdbc.password", password);

			properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
			properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			emf = Persistence.createEntityManagerFactory("personaPU", properties);

		} catch (Exception e) {

			e.printStackTrace(System.out);
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		emf.close();
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

}
