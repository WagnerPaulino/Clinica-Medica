package com.clinicaMedica.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table(name = "proprietario")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "uuid")
public class Proprietario extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToMany(mappedBy = "proprietario")
	private List<Recepcionista> recepcionistas;
	@OneToMany(mappedBy = "proprietario")
	private List<Medico> medico;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Recepcionista> getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(List<Recepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public List<Medico> getMedico() {
		return medico;
	}

	public void setMedico(List<Medico> medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + id;
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
		Proprietario other = (Proprietario) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
