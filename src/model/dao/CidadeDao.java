package model.dao;

import java.util.List;

import model.entities.Cidade;
import model.entities.Estado;

public interface CidadeDao {
	
	void insert(Cidade cidade);
	void update(Cidade cidade);
	void deleteById(Integer id);
	Cidade findById(Integer id);
	List<Cidade> findByEstado(Estado estado);
	List<Cidade> findAll();

}
