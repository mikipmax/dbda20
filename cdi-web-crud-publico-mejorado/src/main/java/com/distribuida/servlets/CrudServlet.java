package com.distribuida.servlets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.distribuida.dto.Persona;
import com.distribuida.servicios.ServicioDireccionI;
import com.distribuida.servicios.ServicioPersonaI;

@WebServlet("/crud")
public class CrudServlet extends HttpServlet {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Inject
	private ServicioPersonaI servicioPersona;
	@Inject
	private ServicioDireccionI servicioDireccion;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Persona> personas = servicioPersona.listar();
		req.setAttribute("personas", personas);

		req.getRequestDispatcher("persona/listar.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");

		int id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		int direccion = op.equals("3") ? 0: Integer.valueOf(req.getParameter("direccion")) ;
		String correo = req.getParameter("correo");
		switch (op) {
		case "1":
			servicioPersona.crear(new Persona(id, nombre, direccion, correo));
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			break;

		case "2":
			servicioPersona.editar(new Persona(id, nombre, direccion, correo));
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			break;
		case "3":
			servicioPersona.eliminar(new Persona(id));
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			break;

		}
	}

}
