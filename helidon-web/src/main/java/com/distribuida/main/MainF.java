package com.distribuida.main;

import java.util.concurrent.TimeUnit;

import com.distribuida.restclient.Rest;

import io.helidon.webserver.Routing;

import io.helidon.webserver.WebServer;
import io.helidon.webserver.jersey.JerseySupport;

public class MainF {
	public static void main(String[] args) {


		
		  WebServer webServer = WebServer
	                .create(Routing.builder().register("/cliente", JerseySupport.builder().register(Rest.class).build())) 
	                .start() 
	                .await(10, TimeUnit.SECONDS); 

	        System.out.println("Server started at: http://localhost:" + webServer.port());
	}
}
