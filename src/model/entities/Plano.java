package model.entities;

import java.io.Serializable;

public class Plano implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer cod;
	private Float valor;
	private String tipo;
	

	public Plano() {
	}

	public Plano(Integer cod, Float d, String tipo) {
		this.cod = cod;
		this.valor = d;
		this.tipo = tipo;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		Plano other = (Plano) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Plano [cod=" + cod + ", valor=" + valor + ", tipo=" + tipo + "]";
	}
	
}
