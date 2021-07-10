package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Agendamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cod;
	private Date data;	
	private Horario codHorario;
	private Aluno codAluno;
	
	public Agendamento() {
	}
	

	public Agendamento(Integer cod, Date data, Horario codHorario, Aluno codAluno) {
		this.cod = cod;
		this.data = data;
		this.codHorario = codHorario;
		this.codAluno = codAluno;
	}


	public Integer getCod() {
		return cod;
	}


	public void setCod(Integer cod) {
		this.cod = cod;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Horario getCodHorario() {
		return codHorario;
	}


	public void setCodHorario(Horario codHorario) {
		this.codHorario = codHorario;
	}


	public Aluno getCodAluno() {
		return codAluno;
	}


	public void setCodAluno(Aluno codAluno) {
		this.codAluno = codAluno;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Agendamento [cod=" + cod + ", data=" + data + ", codHorario=" + codHorario + ", codAluno=" + codAluno
				+ "]";
	}
	
}
