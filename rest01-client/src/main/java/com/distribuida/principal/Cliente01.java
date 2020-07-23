package com.distribuida.principal;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Cliente01 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:9090/rest01/hola/Mik");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET"); 
		connection.setRequestProperty("Accept", "application/json");
		int httpCode=connection.getResponseCode(); //Conseguimos el codigo de estado que nos retorna el servidor
		if (httpCode!=HttpURLConnection.HTTP_OK) {
			System.out.println("Error: "+httpCode);
			return;
		}
		//Leer flujo de datos desde el servidor
		//commons-io
		InputStream is=connection.getInputStream();
		String json=IOUtils.toString(is, Charset.defaultCharset());
		System.out.println("Datos devueltos: "+json);
		//Leer y escribir Json
		//Jackson-databind
		ObjectMapper mapper=new ObjectMapper();
		Persona per=mapper.readValue(json, Persona.class);
		System.out.println("Nombre: "+per.getNombre()+" Mensaje: "+per.getMensaje());
	}
}
