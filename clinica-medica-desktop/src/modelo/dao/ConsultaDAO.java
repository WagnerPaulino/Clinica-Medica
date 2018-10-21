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
import modelo.bean.Consulta;
import modelo.bean.Recepcionista;
import modelo.bean.Medico;

/**
 *
 * @author 
 */
public class ConsultaDAO {
    private Connection con  = null;
    private String sql = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public void incluirConsulta (Consulta consulta) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "INSERT INTO consulta (codigo_Prontuario, especialidade, diagnostico, exame, tratamento, "
                    + "sintomas, descricao, dtConsulta, dtRetorno, valorConsulta) " + "VALUES (?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, consulta.getCodigo_Prontuario());
            ps.setString(3, consulta.getDtConsulta());
            ps.setString(4, consulta.getDtRetorno());
            ps.setDouble(5, consulta.getValorConsulta());
            ps.setString(7, consulta.getDescricao());
            ps.executeUpdate();
            con.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao fazer consulta:\n " + e);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
        }       
    }
    public Consulta buscarconsulta (int codigo) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "SELECT * FROM consulta WHERE codigo_Prontuario = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if(!rs.next()){
                throw new Exception("Nenhum registro encontrado");
            }
            

            int codigo_Prontuario= rs.getInt("codigo_Prontuario");
            String especialidade = rs.getString("especialidade");
            String diagnostico = rs.getString("dignostico");
            String exame = rs.getString("exame");
            String tratamento = rs.getString("tratamento");
            String sintomas = rs.getString("sintomas");
            String descricao = rs.getString("descricao");
            String dtConsulta = rs.getString("dtConsulta");
            String dtRetorno = rs.getString("dtRetorno");
            double valorConsulta = rs.getDouble("valorConsulta");
          
            
            
            return new Consulta(codigo_Prontuario, especialidade, diagnostico, exame, tratamento,
                    sintomas, descricao, dtConsulta, dtRetorno, valorConsulta);
        } catch (Exception e) {
            throw new Exception("Error no DAO da busca na consulta: " + e.getMessage());
        
        }finally{
            con.close();
            rs.close();
        }
    }    
    public void apagarconsulta (Consulta consulta) throws Exception{
        try {
            con = Conexao.conectar();
            sql = "DELETE FROM aluguel WHERE codigo_Prontuario = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,consulta.getCodigo_Prontuario());
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception("Erro no DAO: " + e.getMessage());
        }finally{
            con.close();
        }
        
       }
    
    }
