package model.dao;

import java.util.List;
import model.entities.Estado;

public interface EstadoDao {
	
	void insert(Estado estado);
	void update(Estado estado);
	void deleteById(Estado estado);
	Estado findById(String id);
	List<Estado> findAll();

}
