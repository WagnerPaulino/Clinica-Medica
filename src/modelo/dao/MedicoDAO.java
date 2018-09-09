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
            sql = "INSERT INTO medico (idCrm, codigo_Prontuario, especialidade, diagnostico, exame, tratamento, sintomas, descricao, peso, altura, pressao) VALUES (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, medico.getCodigo_Prontuario());
            ps.setString(2, medico.getEspecialidade());
            ps.setString(3, medico.getDiagnostico());
            ps.setString(4, medico.getExame());
            ps.setString(5, medico.getTratamento());
            ps.setDouble(6, medico.getSintomas());
            ps.setString(7, medico.getDescricao());
            ps.setDouble(8, medico.getPeso());
            ps.setDouble(9, medico.getAltura());
            ps.setDouble(10, medico.getPressao());
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
     public void alterar(Medico medico) throws Exception {
        
        if (medico == null) {
            throw new Exception("Preencha todos os campos para pode realizar o cadastro");
        }
        try {
            con = Conexao.conectar();
            sql = "UPDATE roupa SET codigo_Prontuario = ?, diagnostico = ?, exame = ?, tratamento = ?, sintomas = ?, descricao = ?, "
                    + "peso = ?, altura = ?, pressao= ? WHERE idMedico = ?";
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, medico.getCodigo_Prontuario());
            ps.setString(2, medico.getEspecialidade());
            ps.setString(3, medico.getDiagnostico());
            ps.setString(4, medico.getExame());
            ps.setString(5, medico.getTratamento());
            ps.setDouble(6, medico.getSintomas());
            ps.setString(7, medico.getDescricao());
            ps.setDouble(8, medico.getPeso());
            ps.setDouble(9, medico.getAltura());
            ps.setDouble(10, medico.getPressao());
            
            System.out.println(ps.toString());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception("Erro ao alterar DAO:" + e);
        } finally {
            ps.close();
            con.close();
        }
    }
     public void alterarPeso(Medico medico) throws Exception {
        
        
        try {
            con = Conexao.conectar();
            sql = "UPDATE roupa SET peso = ? WHERE codigo_Prontuario = ?";
            ps = con.prepareStatement(sql);
          
            ps.setDouble(1, medico.getPeso());
            ps.setInt(2, medico.getCodigo_Prontuario());
            
            System.out.println(ps.toString());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception("Erro ao alterar DAO:" + e);
        } finally {
            ps.close();
            con.close();
        }
    }
        
   
            
     public Medico buscarUmaConsulta (int codigo_prontuario) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM medico WHERE codigo_prontuario = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo_prontuario);
            rs = ps.executeQuery();
            if(!rs.next()){
                throw new Exception("Nenhum registro encontrado");
            }
            int idCrm = rs.getInt("idCrm");
            int codigo_Prontuario = rs.getInt("codigo_Prontuario");
            String especialidade = rs.getString("especialidade");           
            String diagnostico = rs.getString("diagnostico");
            String exame = rs.getString("exame");           
            String tratamento = rs.getString("tratamento");
            double sintomas= rs.getInt("sintomas");         
            String descricao = rs.getString("descricao");
            double peso = rs.getDouble("peso");
            double altura = rs.getDouble("altura");
            int pressao = rs.getInt ("pressao");
           
           
           
            return new Medico(idCrm, codigo_Prontuario, especialidade, diagnostico, exame, tratamento, sintomas, descricao, peso, altura, pressao);
            
        } catch (Exception e) {
            throw  new Exception("Erro no DAO: " + e.getMessage());
            
        }finally{
            con.close();
            rs.close();
        }
     
}
     public void excluir (Medico medico) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "DELETE  FROM roupa WHERE codigo_medico = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, medico.getCodigo_Prontuario());
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
             medico.setCodigo_Prontuario(rs.getInt("Codigo_Prontuario"));
             medico.setEspecialidade(rs.getString("especialidade"));
             medico.setDiagnostico(rs.getString("diagnostico"));
             medico.setExame(rs.getString("exame"));
             medico.setTratamento(rs.getString("tratamento"));
             medico.setSintomas(rs.getDouble("sintomas"));
             medico.setDescricao(rs.getString("descricao"));
             medico.setPeso(rs.getInt("peso"));
             medico.setAltura(rs.getDouble("altura"));
             medico.setPressao(rs.getInt("pressao"));
             
               
             
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
                  
                    medico.setCodigo_Prontuario(rs.getInt("Codigo_Prontuario"));
                    medico.setEspecialidade(rs.getString("especialidade"));
                    medico.setDiagnostico(rs.getString("diagnostico"));
                    medico.setExame(rs.getString("exame"));
                    medico.setTratamento(rs.getString("tratamento"));
                    medico.setSintomas(rs.getDouble("sintomas"));
                    medico.setDescricao(rs.getString("descricao"));
                    medico.setPeso(rs.getInt("peso"));
                    medico.setAltura(rs.getDouble("altura"));
                    medico.setPressao(rs.getInt("pressao"));
                    
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
