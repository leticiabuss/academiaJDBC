package model.entities;

import java.io.Serializable;
import java.util.Date;

public class PlanoContratado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer cod;
	private Date dtInicial;
	private Date dtFinal;
	private String formaPagamento;
	private Aluno codAluno;
	private Plano codPlano;
	
	public PlanoContratado() {
	}

	public PlanoContratado(Integer cod, Date dtInicial, Date dtFinal, String formaPagamento, Aluno codAluno,
			Plano codPlano) {
		this.cod = cod;
		this.dtInicial = dtInicial;
		this.dtFinal = dtFinal;
		this.formaPagamento = formaPagamento;
		this.codAluno = codAluno;
		this.codPlano = codPlano;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Date getDtInicial() {
		return dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	public Date getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Aluno getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(Aluno codAluno) {
		this.codAluno = codAluno;
	}

	public Plano getCodPlano() {
		return codPlano;
	}

	public void setCodPlano(Plano codPlano) {
		this.codPlano = codPlano;
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
		PlanoContratado other = (PlanoContratado) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlanoContratado [cod=" + cod + ", dtInicial=" + dtInicial + ", dtFinal=" + dtFinal + ", formaPagamento="
				+ formaPagamento + ", codAluno=" + codAluno + ", codPlano=" + codPlano + "]";
	}

	
}
