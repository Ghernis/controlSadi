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
 * @author Gherni
 */

public class obras implements Serializable{
    private String obra,nombreObra,region,provincia,comitente,adjudicatario,observaciones,actaInicio,habilitacionComercial,descripcion,fechaInicio,fechaFirma,fechaFin;
    private double montoP,montoD,montoT,asign18,asign19,asign17;
    private int plazoContractual;
    private ArrayList<informes> informesM = new ArrayList<informes>();

    @Override
    public String toString() {
        return "obras{" + "obra=" + obra + ", nombreObra=" + nombreObra + ", region=" + region + ", provincia=" + provincia + ", comitente=" + comitente + ", adjudicatario=" + adjudicatario + ", observaciones=" + observaciones + ", actaInicio=" + actaInicio + ", habilitacionComercial=" + habilitacionComercial + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFirma=" + fechaFirma + ", fechaFin=" + fechaFin + ", montoP=" + montoP + ", montoD=" + montoD + ", montoT=" + montoT + ", asign18=" + asign18 + ", asign19=" + asign19 + ", asign17=" + asign17 + ", plazoContractual=" + plazoContractual + ", informesM=" + informesM + '}';
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setComitente(String comitente) {
        this.comitente = comitente;
    }

    public void setAdjudicatario(String adjudicatario) {
        this.adjudicatario = adjudicatario;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setActaInicio(String actaInicio) {
        this.actaInicio = actaInicio;
    }

    public void setHabilitacionComercial(String habilitacionComercial) {
        this.habilitacionComercial = habilitacionComercial;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFirma(String fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setMontoP(double montoP) {
        this.montoP = montoP;
    }

    public void setMontoD(double montoD) {
        this.montoD = montoD;
    }

    public void setMontoT(double montoT) {
        this.montoT = montoT;
    }

    public void setAsign18(double asign18) {
        this.asign18 = asign18;
    }

    public void setAsign19(double asign19) {
        this.asign19 = asign19;
    }

    public void setAsign17(double asign17) {
        this.asign17 = asign17;
    }

    public void setPlazoContractual(int plazoContractual) {
        this.plazoContractual = plazoContractual;
    }

    public void setInformesM(ArrayList<informes> informesM) {
        this.informesM = informesM;
    }

    public String getObra() {
        return obra;
    }

    public String getNombreObra() {
        return nombreObra;
    }

    public String getRegion() {
        return region;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getComitente() {
        return comitente;
    }

    public String getAdjudicatario() {
        return adjudicatario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getActaInicio() {
        return actaInicio;
    }

    public String getHabilitacionComercial() {
        return habilitacionComercial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFirma() {
        return fechaFirma;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public double getMontoP() {
        return montoP;
    }

    public double getMontoD() {
        return montoD;
    }

    public double getMontoT() {
        return montoT;
    }

    public double getAsign18() {
        return asign18;
    }

    public double getAsign19() {
        return asign19;
    }

    public double getAsign17() {
        return asign17;
    }

    public int getPlazoContractual() {
        return plazoContractual;
    }

    public ArrayList<informes> getInformesM() {
        return informesM;
    }
    
    
}
