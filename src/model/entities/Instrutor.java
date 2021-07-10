package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Instrutor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codInstrutor;
	private String nomeInstrutor;
	private String cpf;
	private String telefone;
	private String email;
	private String sexo;
	private Date dtNasc;
	
	public Instrutor() {
	}

	public Instrutor(Integer codInstrutor, String nomeInstrutor, String cpf, String telefone, String email,
			String sexo, Date dtNasc) {
		this.codInstrutor = codInstrutor;
		this.nomeInstrutor = nomeInstrutor;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
		this.dtNasc = dtNasc;
	}

	public Integer getCodInstrutor() {
		return codInstrutor;
	}

	public void setCodInstrutor(Integer codInstrutor) {
		this.codInstrutor = codInstrutor;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codInstrutor == null) ? 0 : codInstrutor.hashCode());
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
		Instrutor other = (Instrutor) obj;
		if (codInstrutor == null) {
			if (other.codInstrutor != null)
				return false;
		} else if (!codInstrutor.equals(other.codInstrutor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instrutor [codInstrutor=" + codInstrutor + ", nomeInstrutor=" + nomeInstrutor + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", email=" + email + ", sexo=" + sexo + ", dtNasc=" + dtNasc + "]";
	}
	
	
}
