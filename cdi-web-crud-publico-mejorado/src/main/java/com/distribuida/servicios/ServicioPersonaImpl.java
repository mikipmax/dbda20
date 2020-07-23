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

import com.distribuida.dto.Persona;
@ApplicationScoped
public class ServicioPersonaImpl implements ServicioPersonaI {

	@Inject
	private DataSource dataSource;
	
	@Override
	public List<Persona> listar() {
		
		List<Persona> lista = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;

		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("SELECT * FROM persona1;");
			rs = pstm.executeQuery();
			while (rs.next()) {
				lista.add(new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getInt("direccion"),
						rs.getString("correo")));
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
	public Persona buscarId(Persona persona) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		Persona personaAux = null;
		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("SELECT * FROM persona1 WHERE id=?;");
			pstm.setInt(1, persona.getId());
			rs = pstm.executeQuery();

			if (rs.absolute(1)) {
				personaAux = new Persona(rs.getInt("id"), rs.getString("nombre"), rs.getInt("direccion"),
						rs.getString("correo"));
			} else {
				System.out.println("Registro no encontrado");
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
		return personaAux;
	}

	@Override
	public void crear(Persona persona) {

		Connection conn = null;

		PreparedStatement pstm = null;
		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("INSERT INTO persona1(id, nombre, direccion, correo) VALUES (?, ?, ?, ?);");
			pstm.setInt(1, persona.getId());
			pstm.setString(2, persona.getNombre());
			pstm.setInt(3, persona.getDireccion());
			pstm.setString(4, persona.getCorreo());
			pstm.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace(System.out);
		} finally {
			try {

				pstm.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace(System.out);
			}

		}

	}

	@Override
	public void editar(Persona persona) {

		Connection conn = null;
	
		PreparedStatement pstm = null;
		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("UPDATE persona1 SET nombre=?, direccion=?, correo=? WHERE id=?;");

			pstm.setString(1, persona.getNombre());
			pstm.setInt(2, persona.getDireccion());
			pstm.setString(3, persona.getCorreo());
			pstm.setInt(4, persona.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace(System.out);
		} finally {
			try {

				pstm.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace(System.out);
			}

		}

	}

	@Override
	public void eliminar(Persona persona) {

		Connection conn = null;
		
		PreparedStatement pstm = null;
		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement("DELETE FROM persona1 WHERE id=?;");
			pstm.setInt(1, persona.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace(System.out);
		} finally {
			try {

				pstm.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace(System.out);
			}

		}

	}

}
