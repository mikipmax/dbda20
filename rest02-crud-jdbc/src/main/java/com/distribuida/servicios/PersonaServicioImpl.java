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

import com.distribuida.clases.Persona;

@ApplicationScoped
public class PersonaServicioImpl implements PersonaServicioI {

	@Inject
	private DataSource datasource;

	@Override
	public List<Persona> listar() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		List<Persona> lista = new ArrayList<>();
		try {
			conn = datasource.getConnection();
			pstm = conn.prepareStatement("SELECT id, nombre, direccion, correo FROM persona;");
			rs = pstm.executeQuery(); // Ejecuto la sentencia
			// Recorro el resulset y añado a una lista
			while (rs.next()) {
				lista.add(new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("direccion"),
						rs.getString("correo")));
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

		return lista;
	}

	@Override
	public Persona buscarId(int id) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		Persona perAux = null;
		try {
			conn = datasource.getConnection();
			pstm = conn.prepareStatement("SELECT id, nombre, direccion, correo FROM persona WHERE id=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery(); // Ejecuto la sentencia
			// Obtengo el registro de la búsqueda
			while (rs.next()) {

				perAux = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getString("direccion"),
						rs.getString("correo"));
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

	@Override
	public void crear(Persona per) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = datasource.getConnection();
			pstm = conn.prepareStatement("INSERT INTO persona(id, nombre, direccion, correo) VALUES (?, ?, ?, ?);");
			pstm.setInt(1, per.getId());
			pstm.setString(2, per.getNombre());
			pstm.setString(3, per.getDireccion());
			pstm.setString(4, per.getCorreo());
			pstm.executeUpdate(); // Ejecuto la sentencia
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			// Cierro los objetos: prepareStatement y la conexión
			try {

				pstm.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
	}

	@Override
	public void editar(int id, Persona per) {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = datasource.getConnection();
			pstm = conn.prepareStatement("UPDATE persona SET nombre=?, direccion=?, correo=? WHERE id=?;");

			pstm.setString(1, per.getNombre());
			pstm.setString(2, per.getDireccion());
			pstm.setString(3, per.getCorreo());
			pstm.setInt(4, id);
			pstm.executeUpdate(); // Ejecuto la sentencia
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			// Cierro los objetos: prepareStatement y la conexión
			try {

				pstm.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
	}

	@Override
	public void eliminar(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = datasource.getConnection();
			pstm = conn.prepareStatement("DELETE FROM persona WHERE id=?;");
			pstm.setInt(1, id);
			pstm.executeUpdate(); // Ejecuto la sentencia
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			// Cierro los objetos: prepareStatement y la conexión
			try {

				pstm.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
	}

}
