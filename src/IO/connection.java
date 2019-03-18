/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;


import java.sql.*;
/**
 *
 * @author Gherni
 */
public class connection {
    String jdbUrl = "jdbc:postgresql://localhost:5432/controlSadi";
    String username = "postgres";
    String password = "47162897Enferis.";
    
    //database variables--
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    public connection(){
        
    }
    public void connect(){
        try{
            conn = DriverManager.getConnection(jdbUrl,username,password);
            System.out.println("Se realizo la conexion correctamente");
            
            
        }catch(SQLException e){
                    System.out.println("Exception: "+e);
        }
    }
    
    public void disconect(){
        try{
            if(stmt!=null){
                stmt.close();
            }
            if(rs!=null){
                rs.close();
            }
            if(conn!=null){
                conn.close();
            }
            System.out.println("Desconectado correctamente");   
                    
        }catch(SQLException e){
            System.out.println("Exception: "+e);
        }
    }
}
