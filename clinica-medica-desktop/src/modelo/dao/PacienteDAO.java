/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.bean.Paciente;

/**
 *
 */
public class PacienteDAO {
    private Connection con = null;
    private String sql = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void save(Paciente paciente) throws Exception{
        if (paciente.getIdPaciente()== 0) {
            this.incluir(paciente);
        }else{
            this.atualizar(paciente);
        }
    }
    
    public void incluir(Paciente paciente) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO cliente (nome_paciente, rg, cpf, dtNascimento, sexo, rua, numero_casa, cidade, bairro, cep, residencial, celular, celular2, email) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getNome());
            ps.setInt(2, paciente.getRg());
            ps.setString(3, paciente.getCpf());            
            ps.setString(4, paciente.getDtNascimento());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getRua());
            ps.setInt(7, Integer.parseInt(paciente.getNumCasa()));
            ps.setString(8, paciente.getCidade());
            ps.setString(9, paciente.getBairro());
            ps.setString(10, paciente.getCep());
            ps.setString(11, paciente.getResidencial());
            ps.setString(12, paciente.getCelular());
            ps.setString(14, paciente.getEmail());
            ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }finally{
            con.close();
        } 
    }
    
    public void atualizar (Paciente paciente) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "UPDATE cliente SET nome_Paciente = ?, rg = ?, cpf = ?, dtNascimento = ?, sexo = ?, rua = ?, numero_casa = ?, cidade = ?, bairro = ?, cep = ?,"
                    + "residencial = ?, celular = ?, celular2 = ?, email = ? WHERE idCliente = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getNome());
            ps.setInt(2, paciente.getRg());
            ps.setString(3, paciente.getCpf());
            ps.setString(4, paciente.getDtNascimento());
            ps.setString(5, paciente.getSexo());
            ps.setString(6, paciente.getRua());
            ps.setString(7, paciente.getNumCasa());
            ps.setString(8, paciente.getCidade());
            ps.setString(9, paciente.getBairro());
            ps.setString(10, paciente.getCep());
            ps.setString(11, paciente.getResidencial());
            ps.setString(12, paciente.getCelular());
            ps.setString(14, paciente.getEmail());
            ps.setInt(15, paciente.getIdPaciente());
            System.out.println(ps.toString());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }finally{
            con.close();
        } 
    }
    
    public Paciente buscarUmPaciente (String cpf) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM cliente WHERE cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if(!rs.next()){
                throw new Exception("Nenhum registro encontrado");
            }
            int idPaciente = rs.getInt("idPaciente");
            String nome = rs.getString("nome_Paciente");
            int rg  = rs.getInt("rg");
            String dtNascimento = rs.getString("dtNascimento");
            String sexo = rs.getString("sexo");
            String rua = rs.getString("rua");
            String numCasa = rs.getString("numero_casa");
            String cidade = rs.getString("cidade");
            String bairro = rs.getString("bairro");
            String cep = rs.getString("cep");
            String residencial = rs.getString("residencial");
            String celular = rs.getString("celular");
            String email = rs.getString("email");
           
            return new Paciente(idPaciente, dtNascimento, sexo,  numCasa, cidade, bairro, cep, residencial, rg, nome, cpf, rg, rua, celular, email);
        } catch (Exception e) {
            throw  new Exception("Erro no DAO: " + e.getMessage());
            
        }finally{
            con.close();
            rs.close();
        }
    }
    
    
    public void excluir (Paciente cliente) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "DELETE  FROM cliente WHERE cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception("Erro no DAO: " + e.getMessage());
            
        }finally{
            con.close();
        }
        
        
        
    }
}
