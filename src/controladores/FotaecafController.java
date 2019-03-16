/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import IO.escribirBinario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import IO.obra;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Gherni
 */
public class FotaecafController implements Initializable {

    @FXML
    private AnchorPane pnFotae;
    public static AnchorPane pFotae;
    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private HBox btnTXT;
    @FXML
    private Label txtExport;
    @FXML
    private HBox btnExcel;
    @FXML
    private Label excelExport;
    @FXML
    private HBox btnPDF;
    @FXML
    private Label pdfExport;
    @FXML
    private Label titFotae;
    @FXML
    private VBox vboxFotae;
    @FXML
    private Label txtTitulo;
    @FXML
    private RowConstraints gridPane;
    @FXML
    private Label lbRegion;
    @FXML
    private Label lbComitente;
    @FXML
    private Label lbProvincia;
    @FXML
    private Label lbAdjudicatario;
    @FXML
    private Label lbPlazo;
    @FXML
    private Label lbFechaFirma;
    @FXML
    private Label lbActa;
    @FXML
    private Label lbHabilitacion;
    @FXML
    private Label lbFechaInicio;
    @FXML
    private Label lbAsign17;
    @FXML
    private Label lbAsign18;
    @FXML
    private Label lbAsign19;
    @FXML
    private Label lbMontoD;
    @FXML
    private Label lbMontoT;
    @FXML
    private Label lbFechaFin;
    @FXML
    private Label lbMontoP;
    @FXML
    private Label lbDescripcion;
    @FXML
    private Label txtDescripcion;
    @FXML
    private Label lbComentarios;
    @FXML
    private JFXTextArea areaComentarios;
    @FXML
    private JFXButton btnAgregar;
    private String[] listaObras;
    private String obraSel="";
    private HashMap<String,obra> obras;
    private HashMap<String,ArrayList> comentarios;
    @FXML
    private JFXListView<String> listComentarios;
    @FXML
    private JFXComboBox<String> desplegableObras;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pFotae=pnFotae;
        escribirBinario es = new escribirBinario("bd.ext");
        obras = es.leerBinPCObras();
        listaObras = new String[obras.size()];
        ArrayList listaO = new ArrayList();
        Iterator it = obras.entrySet().iterator();
        int cont=0;
        while(it.hasNext()){
            Map.Entry entry= (Map.Entry)it.next();
            listaObras[cont]=(String)entry.getKey();
            listaO.add((String)entry.getKey());
            cont++;
        }
        comentarios = new HashMap<String,ArrayList>();
        obraSel = listaObras[0];
        escribirBinario es2 = new escribirBinario("coments.ext");
        comentarios = es2.leerBinPCComents();
        cargaObra(obraSel);
        btnAgregar.setDisable(false);
        areaComentarios.setEditable(true);
        
        desplegableObras.getItems().addAll(listaObras);
        desplegableObras.setValue(obraSel);
        
    }    
    public void cargaObra(String o){
        areaComentarios.clear();
        obra aux = obras.get(o);
        txtTitulo.setText(aux.obra+" - "+aux.nombreObra);
        lbRegion.setText(aux.region);
        lbComitente.setText(aux.comitente);
        lbProvincia.setText(aux.provincia);
        lbActa.setText(aux.actaInicio);
        lbAdjudicatario.setText(aux.adjudicatario);
        lbHabilitacion.setText(aux.habilitacionComercial);
        
        listComentarios.getItems().clear();
        
        if(comentarios.containsKey(obraSel)){
            Iterator it2 = comentarios.get(obraSel).iterator();
            while(it2.hasNext()){
                String comen = (String)it2.next();
                listComentarios.getItems().add(comen);
            }
        }
        
    }

    @FXML
    private void handleAgregar(ActionEvent event) {
//        System.out.println("holi");
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
       LocalDateTime now = LocalDateTime.now();
       String comentario = dtf.format(now)+" - Pablo Moromizato - "+areaComentarios.getText();
       if(comentarios.containsKey(obraSel)){
           comentarios.get(obraSel).add(comentario);
       }
       else{
           ArrayList<String> a = new ArrayList();
           a.add(comentario);
           comentarios.put(obraSel, a);
       }
               
        listComentarios.getItems().add(comentario);
        escribirBinario es = new escribirBinario("coments.ext");
        es.escribirComentario(comentarios);
    }

    @FXML
    private void handleLista(ActionEvent event) {
            System.out.println(desplegableObras.getSelectionModel().getSelectedItem());
            obraSel = desplegableObras.getSelectionModel().getSelectedItem();
            cargaObra((String)desplegableObras.getSelectionModel().getSelectedItem());
    }

    
    
}
