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
import model.dao.AlunoDao;
import model.entities.Aluno;
import model.entities.Cidade;
import model.entities.Estado;

public class AlunoDaoJDBC implements AlunoDao{
	
	private Connection conn;
	
	public AlunoDaoJDBC( Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Aluno aluno) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO aluno "
				+ "(nome, cpf, telefone, email, sexo, dtNasc, rua, bairro, cep, codCidade)"
				+ "VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getCpf());
			st.setString(3, aluno.getTelefone());
			st.setString(4, aluno.getEmail());
			st.setString(5, aluno.getSexo());
			st.setDate(6, new java.sql.Date(aluno.getDtNasc().getTime()));
			st.setString(7, aluno.getRua());
			st.setString(8, aluno.getBairro());
			st.setInt(9, aluno.getCep());
			st.setInt(10, aluno.getCodCidade().getCod());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					aluno.setCodAluno(id);
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
	public void update(Aluno aluno) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"update aluno "
				+ "set nome = ?, cpf = ?, telefone = ?, email = ?, sexo = ?, dtNasc = ?, rua = ?, bairro = ?, cep = ?, codCidade = ? "
				+ "where codAluno = ?");
			
			st.setString(1, aluno.getNome());
			st.setString(2, aluno.getCpf());
			st.setString(3, aluno.getTelefone());
			st.setString(4, aluno.getEmail());
			st.setString(5, aluno.getSexo());
			st.setDate(6, new java.sql.Date(aluno.getDtNasc().getTime()));
			st.setString(7, aluno.getRua());
			st.setString(8, aluno.getBairro());
			st.setInt(9, aluno.getCep());
			st.setInt(10, aluno.getCodCidade().getCod());
			st.setInt(11, aluno.getCodAluno());
			
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
			st = conn.prepareStatement("DELETE FROM aluno where codAluno = ?");
			
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
	public Aluno findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findAlunoCidade(Estado estado) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"select aluno.nome, cidade.nome, estado.codEstado, estado.nome from aluno "  
				+ "inner join cidade on cidade.codCidade = aluno.codCidade " 
				+ "inner join estado on estado.codEstado = cidade.codEstado " 
				+ "where estado.codEstado = ?");
		
			st.setString(1, estado.getCod());
			System.out.println(st);
			rs = st.executeQuery();
						
			List<Aluno> listAluno = new ArrayList<>();
			Map<Integer, Estado> mapEstado = new HashMap<>();
			Map<Integer, Cidade> mapCidade = new HashMap<>();

			while (rs.next()) {
				
				Estado est = mapEstado.get(rs.getInt("codEstado"));
				Cidade cid = mapCidade.get(rs.getInt("codCidade"));
				
				if (est == null) {
					est = instantiateEstado(rs);
					mapEstado.put(rs.getInt("codEstado"), est);
				}
				
				if (cid == null) {
					cid = instantiateCidade(rs, est);
					mapCidade.put(rs.getInt("codCidade"), cid);
				}
				
				Aluno aluno = instantiateAluno(rs, cid);
				listAluno.add(aluno);
			}
			return listAluno;
			
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
	
	private Aluno instantiateAluno(ResultSet rs, Cidade cidade) throws SQLException{
		Aluno aluno = new Aluno();
		aluno.setNome(rs.getString("nome"));
		aluno.setCpf(rs.getString("cpf"));
		aluno.setTelefone(rs.getString("telefone"));
		aluno.setEmail(rs.getString("email"));
		aluno.setSexo(rs.getString("sexo"));
		aluno.setDtNasc(rs.getDate("dtNasci"));
		aluno.setRua(rs.getString("rua"));
		aluno.setBairro(rs.getString("bairro"));
		aluno.setCep(rs.getInt("cep"));
		aluno.setCodCidade(cidade);
		return aluno;
	}
	
	private Estado instantiateEstado(ResultSet rs) throws SQLException{
		Estado estado = new Estado();
		estado.setCod(rs.getString("codEstado"));
		estado.setNome(rs.getString("nome"));
		return estado;
	}

}
