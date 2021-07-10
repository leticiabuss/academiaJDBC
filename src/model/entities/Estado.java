package model.entities;

import java.io.Serializable;

public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cod;
	private String nome;
	
	public Estado() {
	}

	public Estado(String cod, String nome) {
		super();
		this.cod = cod;
		this.nome = nome;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		Estado other = (Estado) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estado [cod=" + cod + ", nome=" + nome + "]";
	}

}
