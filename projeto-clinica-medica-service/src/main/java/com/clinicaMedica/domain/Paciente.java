package com.clinicaMedica.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name = "paciente")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "uuid")
public class Paciente extends Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPaciente;
	
	@ManyToMany(mappedBy= "pacientes")
    private List<Recepcionista> recepcionistas;

    public Paciente() {
    }

    public Paciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Paciente(Long idPaciente, int codigo, String nome, String cpf, int rg, String celular, String residencial, String email, String dtNascimento, String sexo, String rua, String numCasa, String cidade, String bairro, String cep) {
        super(nome, cpf, rg, celular, residencial, email, dtNascimento, sexo, rua, numCasa, cidade, bairro, cep);
        this.idPaciente = idPaciente;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

	public List<Recepcionista> getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(List<Recepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((idPaciente == null) ? 0 : idPaciente.hashCode());
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
		Paciente other = (Paciente) obj;
		if (idPaciente == null) {
			if (other.idPaciente != null)
				return false;
		} else if (!idPaciente.equals(other.idPaciente))
			return false;
		return true;
	}

	    
}