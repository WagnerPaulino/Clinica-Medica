/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.bean.Medico;
import conexao.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diloan
 */
public class MedicoDAO {
    private Connection con = null;
    private String sql = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void save(Medico medico) throws Exception{
        if (medico.getIdCrm() == 0) {
            this.incluir(medico);
        }else{
            this.alterar(medico);
        }
    }
   
    public void incluir (Medico medico) throws Exception{
        
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO medico (int idCrm, String especialidade, int codigo, String nome, String cpf, int rg, String celular, String residencial, String email, String dtNascimento, "
                    + "+ String sexo, String rua, String numCasa, String cidade, String bairro, String cep) VALUES (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, medico.getIdCrm());
            ps.setString(2, medico.getEspecialidade());
           
            if (medico == null) {
            throw new Exception("Preencha todos os campos para pode realizar o cadastro");
        }
            ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }finally{
            con.close();
        }
        
        
        
    }

    public MedicoDAO() {
    }
     public void alterar(Medico medico) throws Exception {
        
        if (medico == null) {
            throw new Exception("Preencha todos os campos para pode realizar o cadastro");
        }
        try {
            con = Conexao.conectar();
            sql = "UPDATE medico SET int idCrm =?, String especialidade = ?,  WHERE idMedico = ?";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, medico.getIdCrm());
            ps.setString(2, medico.getEspecialidade());
           
            
            System.out.println(ps.toString());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception("Erro ao alterar DAO:" + e);
        } finally {
            ps.close();
            con.close();
        }
    }
     public void excluir (Medico medico) throws Exception {
        
        
        try {
            con = Conexao.conectar();
            sql = "UPDATE medico SET idCrm = ? WHERE especialidade = ?";
            ps = con.prepareStatement(sql);
          
             ps.setInt(1, medico.getIdCrm());
            ps.setString(2, medico.getEspecialidade());
            
            System.out.println(ps.toString());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception("Erro ao alterar DAO:" + e);
        } finally {
            ps.close();
            con.close();
        }
    }
        
             
     public Medico buscarmedico (int idCrm ) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM medico WHERE idCrm = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCrm );
            rs = ps.executeQuery();
            if(!rs.next()){
                throw new Exception("Nenhum registro encontrado");
            }
          
            String especialidade = rs.getString("especialidade");           
                           
            return new Medico(idCrm,  especialidade);
            
        } catch (Exception e) {
            throw  new Exception("Erro no DAO: " + e.getMessage());
            
        }finally{
            con.close();
            rs.close();
        }
     
}
     public void consultar (Medico medico) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "DELETE  FROM roupa WHERE idCrm = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, medico.getIdCrm());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception("Erro no DAO: " + e.getMessage());
            
        }finally{
            con.close();
        }
    }
     public List<Medico>  buscarMedicoTabela(int codigo_Prontuario) throws Exception{
         List<Medico> busca = new ArrayList<Medico>();
         try {
             con = Conexao.conectar();
             sql = "SELECT * FROM roupa WHERE codigo_prontuario = ?";
             ps = con.prepareStatement(sql);
             ps.setInt(1, codigo_Prontuario);
             rs = ps.executeQuery();
             if(!rs.next()){
                 throw new Exception("Não foi encontrado nenhuma roupa!");
             }
             Medico medico = new Medico();
             medico.setIdCrm(rs.getInt("IdCrm"));
             medico.setEspecialidade(rs.getString("especialidade"));
             
             busca.add(medico);
         } catch (Exception e) {
             throw new Exception("Falha ao buscar medico:\n " + e.getMessage());
         }
         return busca;
     }
     
      public List<Medico> ler() throws SQLException{
          List<Medico> Medico = new ArrayList<>();
          try {
              try {
                  con = Conexao.conectar();
              } catch (Exception e) {
                  JOptionPane.showMessageDialog(null,"Erro ao conectar!"+ e);
              }
              sql = "SELECT * FROM medico";
              ps = con.prepareStatement(sql);
              rs = ps.executeQuery();
              
              while(rs.next()){
                  
                  Medico medico = new Medico();
                  
                    medico.setIdCrm(rs.getInt("IdCrm"));
                    medico.setEspecialidade(rs.getString("especialidade"));
                   
                    
                   medico.add(medico);
              }
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar dados!"+ e);
        }
          finally{
             con.close();
             ps.close();
             rs.close();
          }
          return Medico;
      }
     
     
}
