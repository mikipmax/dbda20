package com.programacion.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.programacion.servicios.ServicioOperaciones;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ServicioOperaciones servicio;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int v1=Integer.valueOf(req.getParameter("num1"));
		int v2=Integer.valueOf(req.getParameter("num2"));
		int respuesta= servicio.sumar(v1, v2);
		PrintWriter pw = res.getWriter();
		//pw.print("Funcionando");
		System.out.println(servicio);
		Enumeration<String> vars = req.getServletContext().getAttributeNames();
		while (vars.hasMoreElements()) {
			String string = (String) vars.nextElement();
			System.out.println(string);

		}
		
		pw.print("<html><body><b> Respuesta: </b>"+respuesta);
		pw.print("<body></html>");
		
		
		
	}
}
