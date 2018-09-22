package com.clinicaMedica.domain;

public class Medico extends Usuario{
    private int idCrm;
    private String especialidade;
    
    public Medico() {
    }

    public Medico(int idCrm, String especialidade) {
        this.idCrm = idCrm;
        this.especialidade = especialidade;
    }

    public Medico(int idCrm, String especialidade, int codigo, String nome, String cpf, int rg, String celular, String residencial, String email, String dtNascimento, String sexo, String rua, String numCasa, String cidade, String bairro, String cep) {
        super(codigo, nome, cpf, rg, celular, residencial, email, dtNascimento, sexo, rua, numCasa, cidade, bairro, cep);
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

    public void setComplemento(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCrm(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMunicipio(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDescricao(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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