/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import IO.escribirBinario;
import IO.informes;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import IO.obra;
import IO.obras;
import IO.sqlPostgres;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import cuadros.tablaInformes;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

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
    private HashMap<String,obras> listObras;
    private HashMap<String,ArrayList> comentarios;
    @FXML
    private JFXListView<String> listComentarios;
    @FXML
    private JFXListView<String> listCorrectivas;
    @FXML
    private JFXComboBox<String> desplegableObras;
    @FXML
    private JFXTreeTableView<tablaInformes> tvInformes;
    
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart<String, Number> chartAvance = new LineChart<String,Number>(xAxis,yAxis);
    @FXML
    private LineChart<String, Number> chartPresu = new LineChart<String,Number>(xAxis,yAxis);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pFotae=pnFotae;
//        escribirBinario es = new escribirBinario("bd.ext");
//        listObras = es.leerBinPCObras();
        getObras();
        
        listaObras = new String[listObras.size()];
        ArrayList listaO = new ArrayList();
        Iterator it = listObras.entrySet().iterator();
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
    public void getObras(){
        sqlPostgres pos = new sqlPostgres();
        pos.connect();
        listObras = pos.queryGetObras("select * from fotae;");
    }
    public void cargaObra(String o){
        areaComentarios.clear();
        obras aux = listObras.get(o);
        txtTitulo.setText(aux.getObra()+" - "+aux.getNombreObra());
        lbRegion.setText(aux.getRegion());
        lbComitente.setText(aux.getComitente());
        lbProvincia.setText(aux.getProvincia());
        lbActa.setText(aux.getActaInicio());
        lbAdjudicatario.setText(aux.getAdjudicatario());
        lbHabilitacion.setText(aux.getHabilitacionComercial());
        lbPlazo.setText(aux.getPlazoContractual()+"");
        lbFechaInicio.setText(aux.getFechaInicio());
        lbAsign17.setText(aux.getAsign17()+"");
        lbAsign18.setText(aux.getAsign18()+"");
        lbAsign19.setText(aux.getAsign19()+"");
        lbFechaFirma.setText(aux.getFechaFirma());
        lbFechaFin.setText(aux.getFechaFin());
        lbMontoD.setText(aux.getMontoD()+"");
        lbMontoP.setText(aux.getMontoP()+"");
        lbMontoT.setText(aux.getMontoT()+"");
        txtDescripcion.setText(aux.getDescripcion());
        listComentarios.getItems().clear();
        
        if(comentarios.containsKey(obraSel)){
            Iterator it2 = comentarios.get(obraSel).iterator();
            while(it2.hasNext()){
                String comen = (String)it2.next();
                listComentarios.getItems().add(comen);
            }
        }
        cargaInformes(aux);
        
       
        
    }
    public void cargaInformes(obras o){
        
        
        //---------------------inicializacion graficos----------
        chartAvance.getData().clear();
        
        xAxis.setLabel("Fecha de informe");
        chartAvance.setTitle(o.getObra()+" - "+o.getNombreObra());
        XYChart.Series series = new XYChart.Series();
        series.setName("Avance de Obra[%]");
        //-------------------------------
        Collection<String> medidas = new ArrayList();
        JFXTreeTableColumn<tablaInformes, String> fecha = new JFXTreeTableColumn<>("fecha");
        fecha.setPrefWidth(150);
        fecha.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<tablaInformes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<tablaInformes, String> param) {
                return param.getValue().getValue().fecha;
            }
        });
        
        JFXTreeTableColumn<tablaInformes, String> presuEj = new JFXTreeTableColumn<>("presuEj");
        presuEj.setPrefWidth(150);
        presuEj.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<tablaInformes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<tablaInformes, String> param) {
                return param.getValue().getValue().presuEj;
            }
        });
        
        JFXTreeTableColumn<tablaInformes, String> avance = new JFXTreeTableColumn<>("avance");
        avance.setPrefWidth(150);
        avance.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<tablaInformes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<tablaInformes, String> param) {
                return param.getValue().getValue().avance;
            }
        });
        
        JFXTreeTableColumn<tablaInformes, String> presuAnualPe = new JFXTreeTableColumn<>("presuAnualPe");
        presuAnualPe.setPrefWidth(150);
        presuAnualPe.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<tablaInformes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<tablaInformes, String> param) {
                return param.getValue().getValue().presuAnualPe;
            }
        });
        
        JFXTreeTableColumn<tablaInformes, String> presuAnualPor = new JFXTreeTableColumn<>("presuAnualPor");
        presuAnualPor.setPrefWidth(150);
        presuAnualPor.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<tablaInformes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<tablaInformes, String> param) {
                return param.getValue().getValue().presuAnualPor;
            }
        });
        
        JFXTreeTableColumn<tablaInformes, String> numInfo = new JFXTreeTableColumn<>("numInfo");
        numInfo.setPrefWidth(150);
        numInfo.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<tablaInformes, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<tablaInformes, String> param) {
                return param.getValue().getValue().numInfo;
            }
        });
        
        ObservableList<tablaInformes> informes = FXCollections.observableArrayList();
        ArrayList<informes> oInf = o.getInformesM();
        Iterator it = oInf.iterator();
        while(it.hasNext()){
            
            informes aux = (informes)it.next();
            informes.add(new tablaInformes(aux.fechaInforme,aux.presupuestoEj+"",aux.avanceFisico+"",aux.presupuestoAnualEjPe+"",aux.presupuestoAnualEjPor+"",aux.numInforme+""));
            //-----------------medidas correctivas---------
            medidas.add(aux.fechaInforme+" - "+aux.medidasCorrectivas);
            //-----------------graficos--------
            series.getData().add(new XYChart.Data(aux.fechaInforme,aux.avanceFisico*100));
        }
        final TreeItem<tablaInformes> root = new RecursiveTreeItem<tablaInformes>(informes, RecursiveTreeObject::getChildren);
        tvInformes.getColumns().setAll(fecha, presuEj, avance,presuAnualPe,presuAnualPor,numInfo);
        tvInformes.setRoot(root);
        tvInformes.setShowRoot(false);
        
        
        listCorrectivas.getItems().addAll(medidas);
        //-------------------cargar graficos----------------------

        chartAvance.getData().add(series);
        
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
