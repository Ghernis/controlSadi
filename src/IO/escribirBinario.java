/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import objetos.usuarios;

/**
 *
 * @author Gherni
 */
public class escribirBinario {
    
    String path="";
    public escribirBinario(String p){
        path = p;
    }
    public void escribirData(usuarios[] u){
//        String path = "bd.ext";
        try{
            //----------------
    	    FileOutputStream fo = new FileOutputStream(path);
    	    ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeInt(u.length);
            for (int i = 0; i < u.length; i++) {
                os.writeObject(u[i]);
            }
  
    	    os.close();
    	    fo.close();
    	   //----------------
           
        }
        catch(Exception e){
            System.out.println("1 "+e);
        }
    }
    public void escribirComentario(HashMap c){
        try{
            //----------------
    	    FileOutputStream fo = new FileOutputStream(path);
    	    ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeInt(c.size());
            Iterator it = c.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry e = (Map.Entry)it.next();
                
                os.writeObject(e.getKey());
                os.writeObject(e.getValue());
            }
           
  
    	    os.close();
    	    fo.close();
    	   //----------------
           
        }
        catch(Exception e){
            System.out.println("1 "+e);
        }
    }
    public HashMap leerBinPCComents(){
        
        //String path = System.getProperty("user.dir")+"\\resources\\data.ext";
        //String path = "C:\\FOTAE.H\\data.ext";
//        path="bd.ext";
        HashMap<String,ArrayList> data= new HashMap<String,ArrayList>();
        try{
            
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream is = new ObjectInputStream(fi);
            
            int cant = is.readInt();
            
            ArrayList<String> aux = new ArrayList<String>();
            String nombreAux="";
//            HashMap<String,obra> data = new HashMap<String,obra>();
            for(int i=0;i<cant;i++){
                
                    //System.out.println(i);
                    nombreAux=(String)is.readObject();
                    aux = (ArrayList<String>)is.readObject();
                    data.put(nombreAux, aux);
                
                
                
            }
            
            is.close();
            fi.close();
           
            
        }catch(Exception e){
            System.out.println("Error: "+e);
            //ap.consolePrint("Error 12:"+e);
        }
        return data;
    }
    public HashMap leerBinPCObras(){
        
        //String path = System.getProperty("user.dir")+"\\resources\\data.ext";
        //String path = "C:\\FOTAE.H\\data.ext";
//        path="bd.ext";
        HashMap<String,obra> data= new HashMap<String,obra>();
        try{
            
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream is = new ObjectInputStream(fi);
            
            int cant = is.readInt();
            
            obra aux = new obra();
            String nombreAux="";
//            HashMap<String,obra> data = new HashMap<String,obra>();
            for(int i=0;i<cant;i++){
                
                    //System.out.println(i);
                    nombreAux=(String)is.readObject();
                    aux = (obra)is.readObject();
                    data.put(nombreAux, aux);
                
                
                
            }
            
            is.close();
            fi.close();
           
            
        }catch(Exception e){
            System.out.println("Error: "+e);
            //ap.consolePrint("Error 12:"+e);
        }
        return data;
    }

    public usuarios[] leerBinPC(){
        
        //String path = System.getProperty("user.dir")+"\\resources\\data.ext";
        //String path = "C:\\FOTAE.H\\data.ext";
//        path="bd.ext";
        usuarios[] us;
        try{
            
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream is = new ObjectInputStream(fi);
            
            int cant = is.readInt();
            us = new usuarios[cant];
            usuarios aux;
//            HashMap<String,obra> data = new HashMap<String,obra>();
            for(int i=0;i<cant;i++){
                
                    //System.out.println(i);
                    us[i]=(usuarios)is.readObject();

            }
            
            is.close();
            fi.close();
           return us;
            
        }catch(Exception e){
            System.out.println("Error: "+e);
            //ap.consolePrint("Error 12:"+e);
            return null;
        }
        
    }
    
}
