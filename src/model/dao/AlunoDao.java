package model.dao;

import java.util.List;

import model.entities.Aluno;
import model.entities.Estado;

public interface AlunoDao {
	
	void insert(Aluno aluno);
	void update(Aluno aluno);
	void deleteById(Integer id);
	Aluno findById(Integer id);
	List<Aluno> findAll();
	List<Aluno> findAlunoCidade(Estado estado);

}
