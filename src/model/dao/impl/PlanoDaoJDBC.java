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
import model.dao.PlanoDao;
import model.entities.Plano;

public class PlanoDaoJDBC implements PlanoDao{
	
	private Connection conn;
	
	public PlanoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Plano plano) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO plano"
				+ "(valor, tipo)"
				+ "VALUES "
				+ "(?, ?)",
				Statement.RETURN_GENERATED_KEYS);
			
			st.setFloat(1, plano.getValor());
			st.setString(2, plano.getTipo());
			
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					plano.setCod(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Plano plano) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"update plano "
				+ "set valor = ?, tipo = ? "
				+ "where codPlano = ?");
			
			st.setFloat(1, plano.getValor());
			st.setString(2, plano.getTipo());
			st.setInt(3, plano.getCod());
			
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
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM plano where codPlano = ?");
			
			st.setInt(1, id);
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
	public Plano findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM plano WHERE codPlano = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Plano plano = new Plano();
				plano.setCod(rs.getInt("codPlano"));
				plano.setTipo(rs.getString("tipo"));
				plano.setValor(rs.getFloat("valor"));
				return plano;
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
	public List<Plano> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM plano ORDER BY codPlano");
			rs = st.executeQuery();

			List<Plano> list = new ArrayList<>();

			while (rs.next()) {
				Plano plano = new Plano();
				plano.setCod(rs.getInt("codPlano"));
				plano.setTipo(rs.getString("tipo"));
				plano.setValor(rs.getFloat("valor"));
				list.add(plano);
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
