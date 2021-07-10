package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import db.DB;
import db.DbException;
import model.dao.EstadoDao;
import model.entities.Estado;

public class EstadoDaoJDBC implements EstadoDao{
	
	private Connection conn;
	
	public EstadoDaoJDBC( Connection conn) {
		this.conn = conn;
	}


	@Override
	public void insert(Estado estado) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO estado"
					+ "(codEstado, nome)"
					+ "VALUES"
					+ "(?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, estado.getCod());
			st.setString(2, estado.getNome());
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Estado estado) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"update estado "
				+ "set codEstado = ?, nome = ? "
				+ "where codEstado = ?");
			
			st.setString(1, estado.getCod());
			st.setString(2, estado.getNome());
			st.setString(3, estado.getCod());
			
			System.out.println(st);
			
			st.executeUpdate();
		
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}		
	}

	@Override
	public void deleteById(Estado estado) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM estado where codEstado = ?");
			
			st.setString(1, estado.getCod());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Estado findById(String id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM estado WHERE codEstado = ?");
			
			st.setString(1, id);
			rs = st.executeQuery();
			System.out.println( st);
			
			if(rs.next()) {
				Estado estado = new Estado();
				estado.setCod(rs.getString("codEstado"));
				estado.setNome(rs.getString("nome"));
				return estado;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Estado> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM estado ORDER BY codEstado");
			rs = st.executeQuery();

			List<Estado> list = new ArrayList<>();

			while (rs.next()) {
				Estado estado = new Estado();
				estado.setCod(rs.getString("codEstado"));
				estado.setNome(rs.getString("nome"));
				list.add(estado);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	

}
