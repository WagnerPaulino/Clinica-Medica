/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 
 */
public class Paciente extends Usuario{
    private int idPaciente;
    

    public Paciente() {
    }

    public Paciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Paciente(int idPaciente, int codigo, String nome, String cpf, int rg, String celular, String residencial, String email, String dtNascimento, String sexo, String rua, String numCasa, String cidade, String bairro, String cep) {
        super(codigo, nome, cpf, rg, celular, residencial, email, dtNascimento, sexo, rua, numCasa, cidade, bairro, cep);
        this.idPaciente = idPaciente;
    }

    public Paciente(int idPaciente, String dtNascimento, String sexo, String numCasa, String cidade, String bairro, String cep, String residencial, int rg, String nome, String cpf, int rg0, String rua, String celular, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

       
    
    
    
}
