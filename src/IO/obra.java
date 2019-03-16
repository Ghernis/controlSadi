/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class obra implements Serializable{
    public String obra,nombreObra,region,provincia,comitente,adjudicatario,observaciones,actaInicio,habilitacionComercial;
//    double montoP,montoD,montoT,asign18,asign19,asign17;
    public HashMap<Integer,Double> montoP,montoD,montoT,asign18,asign19,asign17;
    public HashMap<Integer,String>descripcion,fechaInicio,fechaFirma,fechaFin;
    public int plazoContractual;
    public ArrayList<informes> informesM = new ArrayList<informes>();
//    ArrayList<Integer> numInforme;  
//    ArrayList<String> fechaInforme,medidasCorrectivas;
//    ArrayList<Double> presupuestoEj,avanceFisico,desvioPlazoOriginal,presupuestoAnualEjPor,presupuestoAnualEjPe,plazoAcumulado;
    public obra(){
        montoP = new HashMap<Integer,Double>();
        montoD = new HashMap<Integer,Double>();
        montoT = new HashMap<Integer,Double>();
        asign18 = new HashMap<Integer,Double>();
        asign17 = new HashMap<Integer,Double>();
        asign19 = new HashMap<Integer,Double>();
        fechaInicio = new HashMap<Integer,String>();
        fechaFin = new HashMap<Integer,String>();
        fechaFirma = new HashMap<Integer,String>();
        descripcion = new HashMap<Integer,String>();
        
    }
    public void mostrar(){
        System.out.println("obra: "+obra);
        System.out.println("nombre de obra: "+nombreObra);
        System.out.println("region: "+region);
        System.out.println("provincia: "+provincia);
        System.out.println("comitente: "+comitente);
        System.out.println("adjudicatario "+adjudicatario);
//        System.out.println("medidasCorrectivas: "+medidasCorrectivas);
        System.out.println("observaciones: "+observaciones);
        System.out.println("descripcion: "+descripcion);
        System.out.println("actaInicio: "+actaInicio);
        System.out.println("fechaInicio: "+fechaInicio);
        System.out.println("fechaFirma: "+fechaFirma);
        System.out.println("fechaFin: "+fechaFin);
        System.out.println("habilitacionComercial: "+habilitacionComercial);
        System.out.println("montoP: "+montoP);
        System.out.println("montoT: "+montoT);
        System.out.println("montoD: "+montoD);
        System.out.println("plazoContractual: "+plazoContractual);
        System.out.println("asignacion 17: "+asign17);
        System.out.println("asignacion 18: "+asign18);
        System.out.println("asignacion 19: "+asign19);
        Iterator it = informesM.iterator();
        informes in = (informes)it.next();
        System.out.println("fecha informe :"+in.fechaInforme);
        System.out.println("avanceFisico: "+in.avanceFisico);
        System.out.println("desvioPlazo: "+in.desvioPlazoOriginal);
        System.out.println("medidasCorrectivas: "+in.medidasCorrectivas);
        System.out.println("numInforme: "+in.numInforme);
        System.out.println("plazoAcumulado: "+in.plazoAcumulado);
        System.out.println("presupuestoAnualEjPe: "+in.presupuestoAnualEjPe);
        System.out.println("presupuestoEj: "+in.presupuestoEj);
        System.out.println("presupuestoAnuallEjPor: "+in.presupuestoAnualEjPor);
//        Iterator it = numInforme.iterator();
//        while(it.hasNext()){
//            System.out.println("numero informe: "+it.next());
//        }
    }   

}
