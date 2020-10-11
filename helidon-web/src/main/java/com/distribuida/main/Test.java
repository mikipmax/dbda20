package com.distribuida.main;

import java.util.concurrent.TimeUnit;

import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;

public class Test {
	public static void main(String[] args) {

		WebServer webServer = WebServer.create(Routing.builder().any((req, res) -> res.send("asdfas"))).start()
				.await(10, TimeUnit.SECONDS);

		System.out.println("Server started at: http://localhost:" + webServer.port());
	}
}
