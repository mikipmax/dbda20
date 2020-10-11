
import com.distribuida.servicios.Servicio;

import io.helidon.media.jsonp.JsonpSupport;
import io.helidon.webserver.Routing;

import io.helidon.webserver.WebServer;
import io.helidon.webserver.jersey.JerseySupport;
import io.helidon.webserver.json.JsonSupport;

//NO FUNCIONA AUN
public class Test2 {
	public static void main(String[] args) {

		Routing routing = Routing.builder()
				.register(JsonSupport.create())
				.register("/", new Servicio())

				.build();

		WebServer

				.create(routing)

				.start()

				.thenAccept(ws -> System.out.println("Server started at: http://localhost:" + ws.port()));
	}

}
