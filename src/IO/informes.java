/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author User
 */

public class informes implements Serializable{
    public int numInforme;  
    public String fechaInforme,medidasCorrectivas;
    public double presupuestoEj,avanceFisico,desvioPlazoOriginal,presupuestoAnualEjPor,presupuestoAnualEjPe,plazoAcumulado;
    public informes(int numIn,String fI,String medC,double presEj,double av,double desPl,double presPor,double presPe,double plazAcu){
        numInforme = numIn;fechaInforme=fI;medidasCorrectivas=medC;presupuestoEj=presEj;avanceFisico=av;desvioPlazoOriginal=desPl;presupuestoAnualEjPor=presPor;presupuestoAnualEjPe=presPe;plazoAcumulado=plazAcu;
    }
}
