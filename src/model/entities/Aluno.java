package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codAluno;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String sexo;
	private Date dtNasc;
	private String rua;
	private String bairro;
	private Integer cep;
	
	private Cidade codCidade;
	
	public Aluno() {
	}

	public Aluno(Integer codAluno, String nome, String cpf, String telefone, String email, String sexo, Date dtNasc,
			String rua, String bairro, Integer cep, Cidade codCidade) {
		this.codAluno = codAluno;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
		this.dtNasc = dtNasc;
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
		this.codCidade = codCidade;
	}

	public Integer getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(Integer codAluno) {
		this.codAluno = codAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Cidade getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(Cidade codCidade) {
		this.codCidade = codCidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAluno == null) ? 0 : codAluno.hashCode());
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
		Aluno other = (Aluno) obj;
		if (codAluno == null) {
			if (other.codAluno != null)
				return false;
		} else if (!codAluno.equals(other.codAluno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [codAluno=" + codAluno + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email="
				+ email + ", sexo=" + sexo + ", dtNasc=" + dtNasc + ", rua=" + rua + ", bairro=" + bairro + ", cep="
				+ cep + ", codCidade=" + codCidade + "]";
	}
	
}
