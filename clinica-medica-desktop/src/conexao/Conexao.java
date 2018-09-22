/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Diloan
 */
public class Conexao {
    public static Connection conectar() throws Exception{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/aluguelderoupas", "root", "diloandla13");
            
        }catch(Exception e){
            throw new Exception(e.getMessage());
            
        }
        
        
    }
    
}
