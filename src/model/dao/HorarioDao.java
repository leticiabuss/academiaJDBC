package model.dao;

import java.util.List;
import model.entities.Horario;

public interface HorarioDao {
	
	void insert(Horario horario);
	void update(Horario horario);
	void deleteById(Horario horario);
	Horario findById(Integer id);
	List<Horario> findAll();

}
