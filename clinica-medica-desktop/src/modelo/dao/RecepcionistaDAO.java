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
    
    public void save(Recepcionista funcionario) throws Exception{
        if (funcionario.getIdFuncionario() == 0) {
            this.incluir(funcionario);
        }else{
            this.atualizar(funcionario);
        }
    }
  
    
    public Recepcionista validarUsuario(Recepcionista funcionario) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM funcionario WHERE login = ? AND senha = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, funcionario.getLogin());
            ps.setString(2, funcionario.getSenha());
            rs = ps.executeQuery();
             if (rs.next()) {
                 funcionario.setAdm(rs.getBoolean("adm"));
                return funcionario;
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
    
    public void incluir (Recepcionista funcionario) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO funcionario (cpf, nome_funcionario, login, senha, rua,  celular, celular2, email)VALUES(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(2, funcionario.getNome());
            ps.setString(1, funcionario.getCpf());
            ps.setString(3, funcionario.getLogin());
            ps.setString(4, funcionario.getSenha());
            ps.setString(5, funcionario.getRua());
            ps.setString(6, funcionario.getCelular());
            ps.setString(8, funcionario.getEmail());            
            ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }finally{
            con.close();
        }
       
    }
    public void atualizar (Recepcionista funcionario)throws Exception{
        if (funcionario == null){
            throw new Exception("O valor passado não pode ser nulo");
        }
        try {
          con = Conexao.conectar();
          sql = "UPDATE funcionario SET nome_funcionario = ?, cpf = ?, login = ?, senha = ?, rua = ?, celular = ?,"
                  + " celular2 = ?, email = ? WHERE idFuncionario = ?";
          ps = con.prepareStatement(sql);
          ps.setString(1,funcionario.getNome());
          ps.setString(2,funcionario.getCpf());
          ps.setString(3,funcionario.getLogin());
          ps.setString(4,funcionario.getSenha());
          ps.setString(5,funcionario.getRua());
          ps.setString(6,funcionario.getCelular());
          ps.setString(8,funcionario.getEmail());
          ps.setInt(9, funcionario.getIdFuncionario());
            System.out.println(ps.toString());
          ps.executeUpdate();
        }catch (Exception e){
            throw new Exception("Erro no botão" + e.getMessage());
        } finally {
            con.close();
            
        }
    }
    public void excluir (Recepcionista funcionario)throws Exception{
        try {
            con = Conexao.conectar();
            sql = "DELETE  FROM funcionario WHERE cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, funcionario.getCpf());
            ps.executeUpdate();
            
    }catch (Exception e) {
                throw new Exception(e.getMessage());
                
            }finally{
                con.close();
            }
    
       }
    public Recepcionista buscarUM (String cpf)throws Exception{
        try{
            con = Conexao.conectar();
            sql = "SELECT * FROM funcionario WHERE cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if(!rs.next()){                
                    throw  new Exception("Nenhum registro encontrado");  
        }
            int idFuncionario = rs.getInt("idFuncionario");
            String nome = rs.getString("nome_funcionario");          
            String login = rs.getString("login");
            String senha = rs.getString("senha");
            String rua = rs.getString("rua");
            String celular = rs.getString("celular");
            String celular2 = rs.getString("celular2");
            String email = rs.getString("email");
            
            return new Recepcionista(idFuncionario, login, senha, true, senha);
            
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally{
            con.close();
        }
    }

public Recepcionista buscarCPF (String cpf)throws Exception{
        try{
            con = Conexao.conectar();
            sql = "SELECT * FROM funcionario WHERE cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if(!rs.next()){                
                    throw  new Exception("Nenhum registro encontrado");  
        }
            String cfpExistente = rs.getString("cpf");
            
            
            return new Recepcionista(0, cpf, sql, true, 0, cpf, cpf, 0, cpf, cpf, cpf, sql, cfpExistente);
            
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally{
            con.close();
        }    
    
}
}
