package model.dao;

import java.util.List;
import model.entities.Plano;

public interface PlanoDao {

	void insert(Plano plano);
	void update(Plano plano);
	void deleteById(Integer id);
	Plano findById(Integer id);
	List<Plano> findAll();
	
}
