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
import model.dao.InstrutorDao;
import model.entities.Instrutor;

public class InstrutorDaoJDBC implements InstrutorDao{
	
	private Connection conn;
	
	public InstrutorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Instrutor instrutor) {
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO instrutor"
				+ "(nomeInstrutor, cpf, telefone, email, sexo, dtNasci)"
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, instrutor.getNomeInstrutor());
			st.setString(2, instrutor.getCpf());
			st.setString(3, instrutor.getTelefone());
			st.setString(4, instrutor.getEmail());
			st.setString(5, instrutor.getSexo());
			st.setDate(6, new java.sql.Date(instrutor.getDtNasc().getTime()));
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					instrutor.setCodInstrutor(id);
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
	public void update(Instrutor instrutor) {
		
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"update instrutor "
				+ "set nomeInstrutor = ?, cpf = ?, telefone = ?, email = ?, sexo = ?, dtNasci = ? "
				+ "where codInstrutor = ?");
			
			st.setString(1, instrutor.getNomeInstrutor());
			st.setString(2, instrutor.getCpf());
			st.setString(3, instrutor.getTelefone());
			st.setString(4, instrutor.getEmail());
			st.setString(5, instrutor.getSexo());
			st.setDate(6, new java.sql.Date(instrutor.getDtNasc().getTime()));
			st.setInt(7, instrutor.getCodInstrutor());
			
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
			st = conn.prepareStatement("DELETE FROM instrutor where codInstrutor = ?");
			
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
	public Instrutor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM instrutor WHERE codInstrutor = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Instrutor instrutor = new Instrutor();
				instrutor.setCodInstrutor(rs.getInt("codInstrutor"));
				instrutor.setNomeInstrutor(rs.getString("nomeInstrutor"));
				instrutor.setCpf(rs.getString("cpf"));
				instrutor.setTelefone(rs.getString("telefone"));
				instrutor.setEmail(rs.getString("email"));
				instrutor.setSexo(rs.getString("sexo"));
				instrutor.setDtNasc(rs.getDate("dtNasci"));
				return instrutor;
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
	public List<Instrutor> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM instrutor ORDER BY nomeInstrutor");
			rs = st.executeQuery();

			List<Instrutor> list = new ArrayList<>();

			while (rs.next()) {
				Instrutor instrutor = new Instrutor();
				instrutor.setCodInstrutor(rs.getInt("codInstrutor"));
				instrutor.setNomeInstrutor(rs.getString("nomeInstrutor"));
				instrutor.setCpf(rs.getString("cpf"));
				instrutor.setTelefone(rs.getString("telefone"));
				instrutor.setEmail(rs.getString("email"));
				instrutor.setSexo(rs.getString("sexo"));
				instrutor.setDtNasc(rs.getDate("dtNasci"));
				list.add(instrutor);
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
