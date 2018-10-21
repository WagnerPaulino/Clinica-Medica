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
    
    private int idRecepcionista;
    private String login;
    private String senha;
    private boolean adm;
    private String cfpExistente;

    public Recepcionista() {
    }

    public Recepcionista(int idRecepcionista, String login, String senha, boolean adm, String cfpExistente) {
        this.idRecepcionista = idRecepcionista;
        this.login = login;
        this.senha = senha;
        this.adm = adm;
        this.cfpExistente = cfpExistente;
    }

    public Recepcionista(int idRecepcionista, String login, String senha, boolean adm, String cfpExistente, int codigo, String nome, String cpf, int rg, String celular, String residencial, String email, String dtNascimento, String sexo, String rua, String numCasa, String cidade, String bairro, String cep) {
        super(codigo, nome, cpf, rg, celular, residencial, email, dtNascimento, sexo, rua, numCasa, cidade, bairro, cep);
        this.idRecepcionista = idRecepcionista;
        this.login = login;
        this.senha = senha;
        this.adm = adm;
        this.cfpExistente = cfpExistente;
    }

    public Recepcionista(int idFuncionario, String login, String senha, String nome, String cfp, String rua, String celular, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdRecepcionista() {
        return idRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.idRecepcionista = idRecepcionista;
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

    public boolean getIdFuncionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}
