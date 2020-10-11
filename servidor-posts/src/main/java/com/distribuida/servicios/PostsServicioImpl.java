package com.distribuida.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.transaction.Transactional;


import com.distribuida.dto.Posts;

import io.agroal.api.AgroalDataSource;

@ApplicationScoped
@Transactional
public class PostsServicioImpl implements PostsServicioI {
	@Inject
	AgroalDataSource defaultDataSource;
	

	@Override
	public List<Posts> listar() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		List<Posts> lista = new ArrayList<>();
		System.out.println(defaultDataSource.getConfiguration().connectionPoolConfiguration());
		try {
			conn = defaultDataSource.getConnection();
			pstm = conn.prepareStatement("SELECT id, title,  body, user_id FROM posts;");
			rs = pstm.executeQuery();

			while (rs.next()) {
				lista.add(new Posts(rs.getInt("id"), rs.getString("title"), rs.getString("body"), rs.getInt("user_id")));
			}

		} catch (SQLException e) {

			e.printStackTrace(System.out);
		} finally {

			try {
				rs.close();
				pstm.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}

		}

		return lista;
	}

	@Override
	public Posts buscar(int id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		Posts perAux = null;
		try {
			conn = defaultDataSource.getConnection();
			pstm = conn.prepareStatement("SELECT id, title,  body, user_id FROM posts WHERE id=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery(); 
		
			while (rs.next()) {

				perAux = new Posts(rs.getInt("id"), rs.getString("title"), rs.getString("body"),
						rs.getInt("user_id"));
			}

		} catch (SQLException e) {

			e.printStackTrace(System.out);
		} finally {
			// Cierro los objetos: resulset, prepareStatement y la conexión
			try {
				rs.close();
				pstm.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}

		}

		return perAux;
	}



}
