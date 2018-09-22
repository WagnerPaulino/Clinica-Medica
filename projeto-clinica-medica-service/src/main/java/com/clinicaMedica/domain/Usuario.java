package com.clinicaMedica.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Usuario {
	private String nome;
	private String cpf;
	private int rg;
	private String celular;
	private String residencial;
	private String email;
	private String dtNascimento;
	private String sexo;
	private String rua;
	private String numCasa;
	private String cidade;
	private String bairro;
	private String cep;

	public Usuario() {
	}

	public Usuario(String nome, String cpf, int rg, String celular, String residencial, String email,
			String dtNascimento, String sexo, String rua, String numCasa, String cidade, String bairro, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.celular = celular;
		this.residencial = residencial;
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.rua = rua;
		this.numCasa = numCasa;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
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

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getResidencial() {
		return residencial;
	}

	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + rg;
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
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg != other.rg)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [ nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", celular=" + celular + ", residencial="
				+ residencial + ", email=" + email + ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", rua="
				+ rua + ", numCasa=" + numCasa + ", cidade=" + cidade + ", bairro=" + bairro + ", cep=" + cep + "]";
	}

}