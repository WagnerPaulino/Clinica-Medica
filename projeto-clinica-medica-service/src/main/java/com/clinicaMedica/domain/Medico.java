package com.clinicaMedica.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "medico")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "uuid")
public class Medico extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private int idCrm;
	@Column
	private String especialidade;
	@ManyToOne
	private Proprietario proprietario;
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;

	public Medico() {
	}

	public Medico(int idCrm, String especialidade) {
		this.idCrm = idCrm;
		this.especialidade = especialidade;
	}

	public Medico(int idCrm, String especialidade, int codigo, String nome, String cpf, int rg, String celular,
			String residencial, String email, String dtNascimento, String sexo, String rua, String numCasa,
			String cidade, String bairro, String cep) {
		super(nome, cpf, rg, celular, residencial, email, dtNascimento, sexo, rua, numCasa, cidade, bairro, cep);
		this.idCrm = idCrm;
		this.especialidade = especialidade;
	}

	public int getIdCrm() {
		return idCrm;
	}

	public void setIdCrm(int idCrm) {
		this.idCrm = idCrm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
		result = prime * result + idCrm;
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
		Medico other = (Medico) obj;
		if (id != other.id)
			return false;
		if (idCrm != other.idCrm)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", idCrm=" + idCrm + ", especialidade=" + especialidade + ", proprietario="
				+ proprietario + ", consultas=" + consultas + "]";
	}

}