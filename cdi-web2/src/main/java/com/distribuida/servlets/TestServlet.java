package com.distribuida.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.distribuida.db.ManejadorDb;


@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Inject
	private DataSource dataSource;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	try {
		Connection conn=dataSource.getConnection();
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	
		
	System.out.println(dataSource);
		
		
		
		
	}
}
