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

    
    
    
    
}
