/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author Diloan
 */
public class Recepcionista extends Usuario{
    
    private int idFuncionario;
    private String login;
    private String senha;
    private boolean adm;
    private String cfpExistente;

    public Recepcionista() {
    }

    public Recepcionista(int idFuncionario, String login, String senha, boolean adm, String cfpExistente) {
        this.idFuncionario = idFuncionario;
        this.login = login;
        this.senha = senha;
        this.adm = adm;
        this.cfpExistente = cfpExistente;
    }

    public Recepcionista(int idFuncionario, String login, String senha, boolean adm, String cfpExistente, int codigo, String nome, String cpf, int rg, String celular, String residencial, String email, String dtNascimento, String sexo, String rua, String numCasa, String cidade, String bairro, String cep) {
        super(codigo, nome, cpf, rg, celular, residencial, email, dtNascimento, sexo, rua, numCasa, cidade, bairro, cep);
        this.idFuncionario = idFuncionario;
        this.login = login;
        this.senha = senha;
        this.adm = adm;
        this.cfpExistente = cfpExistente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

   
    
    
}
