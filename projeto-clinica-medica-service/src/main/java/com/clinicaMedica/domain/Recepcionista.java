package com.clinicaMedica.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "recepcionista")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "uuid")
public class Recepcionista extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String login;
	@Column
	private String senha;
	@Column
	private boolean adm;
	@Column
	private String cfpExistente;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Paciente> pacientes;
	@ManyToOne(fetch = FetchType.LAZY)
	private Proprietario proprietario;
	@OneToMany(mappedBy = "recepcionistas")
	private List<Consulta> consultas;

	public Recepcionista() {
	}

	public Recepcionista(int id, String login, String senha, boolean adm, String cfpExistente) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.adm = adm;
		this.cfpExistente = cfpExistente;
	}

	public Recepcionista(int id, String login, String senha, boolean adm, String cfpExistente, int codigo, String nome,
			String cpf, int rg, String celular, String residencial, String email, String dtNascimento, String sexo,
			String rua, String numCasa, String cidade, String bairro, String cep) {
		super(nome, cpf, rg, celular, residencial, email, dtNascimento, sexo, rua, numCasa, cidade, bairro,
				cep);
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.adm = adm;
		this.cfpExistente = cfpExistente;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdm() {
		return adm;
	}

	public void setAdm(boolean adm) {
		this.adm = adm;
	}

	public String getCfpExistente() {
		return cfpExistente;
	}

	public void setCfpExistente(String cfpExistente) {
		this.cfpExistente = cfpExistente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recepcionista other = (Recepcionista) obj;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recepcionista [id=" + id + ", login=" + login + ", senha=" + senha + ", adm=" + adm + ", cfpExistente="
				+ cfpExistente + "]";
	}

}