package com.clinicaMedica.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "consulta")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "uuid")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String especialidade;
	@Column
	private String diagnostico;
	@Column
	private String exame;
	@Column
	private String tratamento;
	@Column
	private String sintomas;
	@Column
	private String descricao;
	@Column
	private double peso;
	@Column
	private double altura;
	@Column
	private int pressao;
	@Column
	private String dtConsulta;
	@Column
	private String dtRetorno;
	@Column
	private double valorConsulta;
	@ManyToOne(fetch = FetchType.LAZY)
	private Recepcionista recepcionistas;
	@ManyToOne(fetch = FetchType.LAZY)
	private Medico medico;

	public Consulta() {
	}

	public Consulta(Long id, String especialidade, String diagnostico, String exame, String tratamento, String sintomas,
			String descricao, double peso, double altura, int pressao, String dtConsulta, String dtRetorno,
			double valorConsulta) {
		this.id = id;
		this.especialidade = especialidade;
		this.diagnostico = diagnostico;
		this.exame = exame;
		this.tratamento = tratamento;
		this.sintomas = sintomas;
		this.descricao = descricao;
		this.peso = peso;
		this.altura = altura;
		this.pressao = pressao;
		this.dtConsulta = dtConsulta;
		this.dtRetorno = dtRetorno;
		this.valorConsulta = valorConsulta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getPressao() {
		return pressao;
	}

	public void setPressao(int pressao) {
		this.pressao = pressao;
	}

	public String getDtConsulta() {
		return dtConsulta;
	}

	public void setDtConsulta(String dtConsulta) {
		this.dtConsulta = dtConsulta;
	}

	public String getDtRetorno() {
		return dtRetorno;
	}

	public void setDtRetorno(String dtRetorno) {
		this.dtRetorno = dtRetorno;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public Recepcionista getRecepcionistass() {
		return recepcionistas;
	}

	public void setRecepcionistas(Recepcionista recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorConsulta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Consulta other = (Consulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(valorConsulta) != Double.doubleToLongBits(other.valorConsulta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", especialidade=" + especialidade + ", diagnostico=" + diagnostico + ", exame="
				+ exame + ", tratamento=" + tratamento + ", sintomas=" + sintomas + ", descricao=" + descricao
				+ ", peso=" + peso + ", altura=" + altura + ", pressao=" + pressao + ", dtConsulta=" + dtConsulta
				+ ", dtRetorno=" + dtRetorno + ", valorConsulta=" + valorConsulta + ", recepcionista=" + recepcionistas
				+ ", medico=" + medico + "]";
	}

}