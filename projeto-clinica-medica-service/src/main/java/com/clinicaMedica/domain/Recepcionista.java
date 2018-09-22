package com.clinicaMedica.domain;

public class Recepcionista extends Usuario{
    
    private int id;
    private String login;
    private String senha;
    private boolean adm;
    private String cfpExistente;

    public Recepcionista() {
    }

    public Recepcionista(int id, String login, String senha, boolean adm, String cfpExistente) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.adm = adm;
        this.cfpExistente = cfpExistente;
    }

    public Recepcionista(int id, String login, String senha, boolean adm, String cfpExistente, int codigo, String nome, String cpf, int rg, String celular, String residencial, String email, String dtNascimento, String sexo, String rua, String numCasa, String cidade, String bairro, String cep) {
        super(codigo, nome, cpf, rg, celular, residencial, email, dtNascimento, sexo, rua, numCasa, cidade, bairro, cep);
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