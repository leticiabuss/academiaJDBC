package model.dao;

import java.util.List;
import model.entities.PlanoContratado;

public interface PlanoContratadoDao {

	void insert(PlanoContratado planoContratado);
	void update(PlanoContratado Contratado);
	void deleteById(PlanoContratado Contratado);
	PlanoContratado findById(Integer id);
	List<PlanoContratado> findAll();
}
