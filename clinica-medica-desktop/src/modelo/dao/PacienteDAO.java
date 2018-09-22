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
 * @author Diloan
 */
public class PacienteDAO {
    private Connection con = null;
    private String sql = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void save(Paciente cliente) throws Exception{
        if (cliente.getIdCliente() == 0) {
            this.incluir(cliente);
        }else{
            this.atualizar(cliente);
        }
    }
    
    public void incluir(Paciente cliente) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO cliente (nome_cliente, rg, cpf, dtNascimento, sexo, rua, numero_casa, cidade, bairro, cep, residencial, celular, celular2, email) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getRg());
            ps.setString(3, cliente.getCpf());            
            ps.setString(4, cliente.getDtNascimento());
            ps.setString(5, cliente.getSexo());
            ps.setString(6, cliente.getRua());
            ps.setInt(7, Integer.parseInt(cliente.getNumCasa()));
            ps.setString(8, cliente.getCidade());
            ps.setString(9, cliente.getBairro());
            ps.setString(10, cliente.getCep());
            ps.setString(11, cliente.getResidencial());
            ps.setString(12, cliente.getCelular());
            ps.setString(13, cliente.getCelular2());
            ps.setString(14, cliente.getEmail());
            ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }finally{
            con.close();
        } 
    }
    
    public void atualizar (Paciente cliente) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "UPDATE cliente SET nome_cliente = ?, rg = ?, cpf = ?, dtNascimento = ?, sexo = ?, rua = ?, numero_casa = ?, cidade = ?, bairro = ?, cep = ?,"
                    + "residencial = ?, celular = ?, celular2 = ?, email = ? WHERE idCliente = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getRg());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getDtNascimento());
            ps.setString(5, cliente.getSexo());
            ps.setString(6, cliente.getRua());
            ps.setString(7, cliente.getNumCasa());
            ps.setString(8, cliente.getCidade());
            ps.setString(9, cliente.getBairro());
            ps.setString(10, cliente.getCep());
            ps.setString(11, cliente.getResidencial());
            ps.setString(12, cliente.getCelular());
            ps.setString(13, cliente.getCelular2());
            ps.setString(14, cliente.getEmail());
            ps.setInt(15, cliente.getIdCliente());
            System.out.println(ps.toString());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }finally{
            con.close();
        } 
    }
    
    public Paciente buscarUmCliente (String cpf) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM cliente WHERE cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if(!rs.next()){
                throw new Exception("Nenhum registro encontrado");
            }
            int idCliente = rs.getInt("idCliente");
            String nome = rs.getString("nome_cliente");
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
            String celular2 = rs.getString("celular2");
            String email = rs.getString("email");
           
            return new Paciente(idCliente, dtNascimento, sexo,  numCasa, cidade, bairro, cep, residencial, rg, nome, cpf, rg, rua, celular, celular2, email);
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
