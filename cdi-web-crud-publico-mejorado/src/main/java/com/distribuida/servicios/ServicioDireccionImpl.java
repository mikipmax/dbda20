package com.distribuida.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.dto.Direccion;

@ApplicationScoped
public class ServicioDireccionImpl implements ServicioDireccionI {
	@Inject
	private DataSource dataSource;

	@Override
	public List<Direccion> listar() {

		Connection conn = null;
		List<Direccion> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("SELECT * FROM direccion");
			rs = pstm.executeQuery();
			while (rs.next()) {
				lista.add(new Direccion(rs.getInt("id_direccion"), rs.getString("descripcion")));
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (SQLException e2) {

			}
		}

		return lista;
	}

	@Override
	public Direccion buscarId(Direccion direccion) {

		Connection conn = null;
		Direccion direccionAux = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("SELECT * FROM direccion WHERE id_direccion=?");
			pstm.setInt(1, direccion.getIdDireccion());
			rs = pstm.executeQuery();
			if (rs.absolute(1)) {
				direccionAux = new Direccion(rs.getInt("id_direccion"), rs.getString("descripcion"));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (SQLException e2) {

			}
		}
		return direccionAux;
	}

	@Override
	public void crear(Direccion direccion) {

		Connection conn = null;

		PreparedStatement pstm = null;
		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("INSERT INTO direccion(id_direccion,descripcion) VALUES (?, ?);");
			pstm.setInt(1, direccion.getIdDireccion());
			pstm.setString(2, direccion.getDescripcion());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {

				pstm.close();
				conn.close();
			} catch (SQLException e2) {

			}
		}
	}

	@Override
	public void editar(Direccion direccion) {

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("UPDATE direccion SET descripcion=? WHERE id_descripcion=?;");

			pstm.setString(1, direccion.getDescripcion());
			pstm.setInt(2, direccion.getIdDireccion());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {

				pstm.close();
				conn.close();
			} catch (SQLException e2) {

			}
		}
	}

	@Override
	public void eliminar(Direccion direccion) {

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("DELETE FROM direccion WHERE id_direccion=?;");
			pstm.setInt(1, direccion.getIdDireccion());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			try {

				pstm.close();
				conn.close();
			} catch (SQLException e2) {

			}
		}
	}

}
