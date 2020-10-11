package com.distribuida.main;

import io.helidon.webserver.Routing;
import io.helidon.webserver.StaticContentSupport;
import io.helidon.webserver.WebServer;

public class Main {
	public static void main(String[] args) {

		WebServer

				.create(Routing.builder()

						.register("/",
								 StaticContentSupport.builder("WEB").welcomeFileName("index.xhtml")
										.build()))

				.start()

				.thenAccept(ws -> System.out.println("Server started at: http://localhost:" + ws.port()));
	}
}
