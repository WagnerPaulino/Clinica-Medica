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
 * @author Alexsandra
 */
public class Conexao {
    public static Connection conectar() throws Exception{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/clinicasmedicas", "admin", "admin");
            
        }catch(Exception e){
            throw new Exception(e.getMessage());
            
        }
        
        
    }
    
}
