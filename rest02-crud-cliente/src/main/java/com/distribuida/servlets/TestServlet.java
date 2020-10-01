package com.distribuida.servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.distribuida.clases.Persona;
import com.distribuida.proxies.PersonaProxy;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private PersonaProxy servicioPersona;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Persona> personas = servicioPersona.lista();
		req.setAttribute("personas", personas);

		req.getRequestDispatcher("persona/listar.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Obtenemos los valores del formulario
		int id = Integer.valueOf(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		String direccion = req.getParameter("direccion");
		String correo = req.getParameter("correo");
		String op = req.getParameter("op");

		switch (op) {
		// En donde 1 es para crear, 2 para actualizar y 3 para eliminar
		case "1":

			servicioPersona.crear(new Persona(id, nombre, direccion, correo));
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			break;

		case "2":
			servicioPersona.actualizar(id, new Persona(nombre, direccion, correo));
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			break;

		case "3":
			servicioPersona.eliminar(id);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			break;
		case "4": 
			Persona per = servicioPersona.buscar(id);
			req.setAttribute("id", id);
			req.setAttribute("nombre", per.getNombre());
			req.setAttribute("direccion", per.getDireccion());
			req.setAttribute("correo", per.getCorreo());
			req.getRequestDispatcher("persona/actualizar.jsp").forward(req, resp);
			break;
		}

	}

}
