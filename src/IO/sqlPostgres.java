/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import com.google.gson.Gson;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Gherni
 */
public class sqlPostgres extends connection{
    public void sqlStatement(String sqls){
        try{
            stmt = conn.createStatement();
            stmt.execute(sqls);
            
            stmt.close();
        }catch(Exception e){
            System.out.println("Exception: "+e);
        }
    }
    public void querySql(String sql){
        System.out.println("query");
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            String query;
            while(rs.next()){
                query=(rs.getString(2));
                Gson gson = new Gson();
                obras o = gson.fromJson(query, obras.class);
                System.out.println("nombre obra: "+o.getNombreObra());
            }
            
        }catch(SQLException e){
            System.out.println("Excepition: "+e);
        }
    }
    public void sqlInsert(String id,obras obj){
        System.out.println("Insert data");
        try{
            Gson gson = new Gson();
            String jsonInput = gson.toJson(obj);
            
            PreparedStatement st = conn.prepareStatement("insert into fotae(id,obra) values(?,?::JSON)");
            st.setString(1,id);
           
            st.setObject(2,jsonInput);
           
            st.executeUpdate();
           
            st.close();
        }catch(SQLException e){
            System.out.println("Exception: "+e);
        }
    }
}
