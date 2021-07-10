package model.dao;

import java.util.List;
import model.entities.Instrutor;

public interface InstrutorDao {
	
	void insert(Instrutor instrutor);
	void update(Instrutor instrutor);
	void deleteById(Integer id);
	Instrutor findById(Integer id);
	List<Instrutor> findAll();

}
