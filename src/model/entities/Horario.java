package model.entities;

import java.io.Serializable;

public class Horario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer cod;
	private Instrutor codInstrutor;
	private Integer hrInicial;
	private Integer hrFinal;
	private String diaDaSemana;
	private Integer limite;
	
	public Horario() {
	}

	public Horario(Integer cod, Instrutor codInstrutor, Integer hrInicial, Integer hrFinal, String diaDaSemana,
			Integer limite) {
		this.cod = cod;
		this.codInstrutor = codInstrutor;
		this.hrInicial = hrInicial;
		this.hrFinal = hrFinal;
		this.diaDaSemana = diaDaSemana;
		this.limite = limite;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Instrutor getCodInstrutor() {
		return codInstrutor;
	}

	public void setCodInstrutor(Instrutor codInstrutor) {
		this.codInstrutor = codInstrutor;
	}

	public Integer getHrInicial() {
		return hrInicial;
	}

	public void setHrInicial(Integer hrInicial) {
		this.hrInicial = hrInicial;
	}

	public Integer getHrFinal() {
		return hrFinal;
	}

	public void setHrFinal(Integer hrFinal) {
		this.hrFinal = hrFinal;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public Integer getLimite() {
		return limite;
	}

	public void setLimite(Integer limite) {
		this.limite = limite;
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
		Horario other = (Horario) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Horario [cod=" + cod + ", codInstrutor=" + codInstrutor + ", hrInicial=" + hrInicial + ", hrFinal="
				+ hrFinal + ", diaDaSemana=" + diaDaSemana + ", limite=" + limite + "]";
	}
	
	
}
