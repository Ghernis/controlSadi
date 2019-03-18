/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gherni
 */
public class testjson {
    
    
    public static void main(String[] args){
        escribirBinario es = new escribirBinario("bd.ext");
        HashMap obr = es.leerBinPCObras();
        HashMap<String,obras> Obras = new HashMap<String,obras>();
        Iterator it = obr.entrySet().iterator();
        String valTest ="";
        while(it.hasNext()){
            Map.Entry<String,obra> aux = (Map.Entry<String,obra>)it.next();
            obra oAux = aux.getValue();
            valTest = aux.getKey();
            obras nueva= new obras();
            nueva.setActaInicio(oAux.actaInicio);
            nueva.setAdjudicatario(oAux.adjudicatario);
            nueva.setAsign17(getValDouble(oAux.asign17));
            nueva.setAsign18(getValDouble(oAux.asign18));
            nueva.setAsign19(getValDouble(oAux.asign19));
            nueva.setComitente(oAux.comitente);
            nueva.setDescripcion(getValString(oAux.descripcion));
            nueva.setFechaFin(getValString(oAux.fechaFin));
            nueva.setFechaFirma(getValString(oAux.fechaFirma));
            nueva.setFechaInicio(getValString(oAux.fechaInicio));
            nueva.setHabilitacionComercial(oAux.habilitacionComercial);
            nueva.setMontoD(getValDouble(oAux.montoD));
            nueva.setMontoP(getValDouble(oAux.montoP));
            nueva.setMontoT(getValDouble(oAux.montoT));
            nueva.setNombreObra(oAux.nombreObra);
            nueva.setObra(oAux.obra);
            nueva.setObservaciones(oAux.observaciones);
            nueva.setPlazoContractual(oAux.plazoContractual);
            nueva.setProvincia(oAux.provincia);
            nueva.setRegion(oAux.region);
            nueva.setInformesM(oAux.informesM);
            
////            System.out.println(nueva.toString());
            Obras.put(aux.getKey(), nueva);
        }
        makeJson(Obras.get(valTest));
        sqlPostgres post = new sqlPostgres();
        post.connect();
//        post.sqlStatement("select * from fotae;");
//        post.sqlInsert(valTest, Obras.get(valTest));
        post.querySql("select * from fotae");
        post.disconect();
        
    }
    public static void makeJson(obras o){
        Gson gson = new Gson();
        String jsonInString = gson.toJson(o);
        try{
            FileWriter fw = new FileWriter("obra.json");
            gson.toJson(o, fw);
            fw.close();
        }catch(Exception e){
            System.out.println("Exception: "+e);
        }
        System.out.println(jsonInString);
    }
    public static String getValString(HashMap<Integer,String> hm){
        
        Iterator it = hm.entrySet().iterator();
        String resu = "";
        while(it.hasNext()){
            Map.Entry<Integer,String> entry = (Map.Entry<Integer,String>) it.next();
            if(!entry.getValue().equals("")){
                
                resu = entry.getValue();
            }
        }
        
        return resu;
    }
    public static double getValDouble(HashMap<Integer,Double> hm){
        
        Iterator it = hm.entrySet().iterator();
        double resu = 0;
        while(it.hasNext()){
            Map.Entry<Integer,Double> entry = (Map.Entry<Integer,Double>) it.next();
            if(entry.getValue()!=0){
                
                resu = entry.getValue();
            }
        }
        
        return resu;
    }
    
            
}
