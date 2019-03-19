/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuadros;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author User
 */
public class tablaInformes extends RecursiveTreeObject<tablaInformes>{
    public StringProperty fecha;
    public StringProperty presuEj;
    public StringProperty avance;
    public StringProperty presuAnualPe;
    public StringProperty presuAnualPor;
    public StringProperty numInfo;
    
    public tablaInformes(String fecha,String presuEj,String avance,String presuAnualPe,String presuAnualPor,String numInfo){
        this.fecha = new SimpleStringProperty(fecha);
        this.presuEj = new SimpleStringProperty(presuEj);
        this.avance = new SimpleStringProperty(avance);
        this.presuAnualPe = new SimpleStringProperty(presuAnualPe);
        this.presuAnualPor = new SimpleStringProperty(presuAnualPor);
        this.numInfo = new SimpleStringProperty(numInfo);
    }
}
