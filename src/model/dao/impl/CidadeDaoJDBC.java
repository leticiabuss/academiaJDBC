package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import db.DB;
import db.DbException;
import model.dao.CidadeDao;
import model.entities.Cidade;
import model.entities.Estado;

public class CidadeDaoJDBC implements CidadeDao{
	
	private Connection conn;
	
	public CidadeDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Cidade cidade) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO cidade"
					+ "(nome, codEstado)"
					+ "VALUES"
					+ "(?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, cidade.getNome());
			st.setString(2, cidade.getCodEstado().getCod());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					cidade.setCod(id);
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
	public void update(Cidade cidade) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"update cidade "
				+ "set nome = ?, codEstado = ? "
				+ "where codCidade = ?");
			
			st.setString(1, cidade.getNome());
			st.setString(2, cidade.getCodEstado().getCod());
			st.setInt(3, cidade.getCod());
			
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
			st = conn.prepareStatement("DELETE FROM cidade where codCidade = ?");
			
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
	public Cidade findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM cidade WHERE codCidade = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Estado estado = instantiateEstado(rs);
				Cidade cidade = instantiateCidade(rs, estado);
				return cidade;
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
	public List<Cidade> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM cidade ORDER BY codCidade");
			rs = st.executeQuery();

			List<Cidade> list = new ArrayList<>();

			while (rs.next()) {
				Estado estado = instantiateEstado(rs);
				Cidade cidade = instantiateCidade(rs, estado);
				list.add(cidade);
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

	@Override
	public List<Cidade> findByEstado(Estado estado) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"select cidade.*, estado.nome from cidade " 
					+ "inner join estado on cidade.codEstado = estado.codEstado " 
					+ "where estado.codEstado = 1;");
		
			st.setString(1, estado.getCod());
			
			rs = st.executeQuery();
			
			List<Cidade> listCidade = new ArrayList<>();
			Map<Integer, Estado> mapEstado = new HashMap<>();
			
			while (rs.next()) {
				
				Estado est = mapEstado.get(rs.getInt("codEstado"));
				
				if (est == null) {
					est = instantiateEstado(rs);
					mapEstado.put(rs.getInt("codEstado"), est);
				}
				
				Cidade cidade = instantiateCidade(rs, est);
				listCidade.add(cidade);
			}
			return listCidade;
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	private Cidade instantiateCidade(ResultSet rs, Estado estado) throws SQLException{
		Cidade cidade = new Cidade();
		cidade.setCod(rs.getInt("codCidade"));
		cidade.setNome(rs.getString("nome"));
		cidade.setCodEstado(estado);
		return cidade;
	}
	
	private Estado instantiateEstado(ResultSet rs) throws SQLException{
		Estado estado = new Estado();
		estado.setCod(rs.getString("codEstado"));
		estado.setNome(rs.getString("nome"));
		return estado;
	}

}
