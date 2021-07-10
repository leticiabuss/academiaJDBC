package model.entities;

import java.io.Serializable;

public class Cidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer cod;
	private String nome;
	private Estado codEstado;
	
	public Cidade() {
	}

	public Cidade(Integer cod, String nome, Estado codEstado) {
		this.cod = cod;
		this.nome = nome;
		this.codEstado = codEstado;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(Estado codEstado) {
		this.codEstado = codEstado;
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
		Cidade other = (Cidade) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [cod=" + cod + ", nome=" + nome + ", codEstado=" + codEstado + "]";
	}
	

}
