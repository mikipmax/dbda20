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

import com.distribuida.dto.Comments;

import io.agroal.api.AgroalDataSource;

@ApplicationScoped
@Transactional
public class CommentsServicioImpl implements CommentsServicioI {
	@Inject
	AgroalDataSource defaultDataSource;

	@Override
	public List<Comments> listar() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		List<Comments> lista = new ArrayList<>();
		System.out.println(defaultDataSource.getConfiguration().connectionPoolConfiguration());
		try {
			conn = defaultDataSource.getConnection();
			pstm = conn.prepareStatement("SELECT id, name,  email, body, post_id FROM comments;");
			rs = pstm.executeQuery();

			while (rs.next()) {
				lista.add(new Comments(rs.getInt("post_id"), rs.getInt("id"), rs.getString("name"),
						rs.getString("email"), rs.getString("body")));
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
	public Comments buscar(int id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		Comments perAux = null;
		try {
			conn = defaultDataSource.getConnection();
			pstm = conn.prepareStatement("SELECT id, name,  email, body, post_id FROM comments WHERE id=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();

			while (rs.next()) {

				perAux = new Comments(rs.getInt("post_id"), rs.getInt("id"), rs.getString("name"),
						rs.getString("email"), rs.getString("body"));
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

		return perAux;
	}

}
