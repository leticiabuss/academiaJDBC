package model.dao;

import java.util.List;

import model.entities.Agendamento;

public interface AgendamentoDao {
	
	void insert(Agendamento agendamento);
	void update(Agendamento agendamento);
	void deleteById(Agendamento agendamento);
	Agendamento findById(Integer id);
	List<Agendamento> findAll();

}
