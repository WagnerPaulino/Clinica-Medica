package com.clinicaMedica.domain;

import java.util.List;

public class Medico extends Usuario {
	private int idCrm;
	private String especialidade;

	private Proprietario proprietario;
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
		super(codigo, nome, cpf, rg, celular, residencial, email, dtNascimento, sexo, rua, numCasa, cidade, bairro,
				cep);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
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
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		if (idCrm != other.idCrm)
			return false;
		return true;
	}

}