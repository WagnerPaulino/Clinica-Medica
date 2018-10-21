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
import javax.swing.JOptionPane;
import modelo.bean.Recepcionista;

/**
 *
 * @author Diloan
 */
public class RecepcionistaDAO {
    private Connection con = null;
    private String sql = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void save(Recepcionista recepcionista) throws Exception{
        if (recepcionista.getIdRecepcionista() == 0) {
            this.incluir(recepcionista);
        }else{
            this.atualizar(recepcionista);
        }
    }
  
    
    public Recepcionista validarUsuario(Recepcionista recepcionista) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM recepcionista WHERE login = ? AND senha = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, recepcionista.getLogin());
            ps.setString(2, recepcionista.getSenha());
            rs = ps.executeQuery();
             if (rs.next()) {
                 recepcionista.setAdm(rs.getBoolean("adm"));
                return recepcionista;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            throw new Exception("Erro\n: " + e);
            
        }finally{
            ps.close();
            rs.close();
        }   
    }
    
    public void incluir (Recepcionista recepcionista) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO funcionario (CfpExistente, nome_recepcionista, login, senha, rua,  celular, email)VALUES(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(2, recepcionista.getNome());
            ps.setString(1, recepcionista.getCfpExistente());
            ps.setString(3, recepcionista.getLogin());
            ps.setString(4, recepcionista.getSenha());
            ps.setString(5, recepcionista.getRua());
            ps.setString(6, recepcionista.getCelular());
           
            ps.setString(8, recepcionista.getEmail());            
            ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }finally{
            con.close();
        }
       
    }
    public void atualizar (Recepcionista recepcionista)throws Exception{
        if (recepcionista == null){
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
          con = Conexao.conectar();
          sql = "UPDATE funcionario SET nome_funcionario = ?, CfpExistente = ?, login = ?, senha = ?, rua = ?, celular = ?,"
                  + " celular2 = ?, email = ? WHERE idFuncionario = ?";
          ps = con.prepareStatement(sql);
          ps.setString(1,recepcionista.getNome());
          ps.setString(2,recepcionista.getCfpExistente());
          ps.setString(3,recepcionista.getLogin());
          ps.setString(4,recepcionista.getSenha());
          ps.setString(5,recepcionista.getRua());
          ps.setString(6,recepcionista.getCelular());
         
          ps.setString(8,recepcionista.getEmail());
          ps.setInt(9, recepcionista.getIdRecepcionista());
            System.out.println(ps.toString());
          ps.executeUpdate();
        }catch (Exception e){
            throw new Exception("Erro no botão" + e.getMessage());
        } finally {
            con.close();
            
        }
    }
    public void excluir (Recepcionista recepcionista)throws Exception{
        try {
            con = Conexao.conectar();
            sql = "DELETE  FROM funcionario WHERE cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, recepcionista.getCfpExistente());
            ps.executeUpdate();
            
    }catch (Exception e) {
                throw new Exception(e.getMessage());
                
            }finally{
                con.close();
            }
    
       }
    public Recepcionista buscarUM (String CfpExistente)throws Exception{
        try{
            con = Conexao.conectar();
            sql = "SELECT * FROM recepcionista  WHERE CfpExistente = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, CfpExistente);
            rs = ps.executeQuery();
            if(!rs.next()){                
                    throw  new Exception("Nenhum registro encontrado");  
        }
            int idRecepcionista = rs.getInt("idRecepcionista");
            String nome = rs.getString("nome_recepcionista");          
            String login = rs.getString("login");
            String senha = rs.getString("senha");
            String rua = rs.getString("rua");
            String celular = rs.getString("celular");
            String email = rs.getString("email");
            String cfpExistente = rs.getString("cfpExistente");
            
            return new Recepcionista(idRecepcionista, login, senha,  nome, cfpExistente, rua, celular, email);
            
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally{
            con.close();
        }
    }

public void buscarCPF (String cpf)throws Exception{
        try{
            con = Conexao.conectar();
            sql = "SELECT * FROM recepcionista WHERE cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if(!rs.next()){                
                    throw  new Exception("Nenhum registro encontrado");  
        }
            String cfpExistente = rs.getString("CfpExistente");
            
                       
            
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally{
            con.close();
        }    
    
}

}