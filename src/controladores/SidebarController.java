/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import static controladores.AgentesController.pAgentes;
import static controladores.CalculosController.pCalculos;
import static controladores.DistribucionController.pDistribucion;
import static controladores.FXMLDocumentController.pTablero;
import static controladores.FotaecafController.pFotae;
import static controladores.GeneracionController.pGeneracion;
import static controladores.HitoricosController.pHistoricos;
import static controladores.ResumenMensualController.pResumen;
import static controladores.SadiController.pSadi;
import static controladores.TransporteController.pTransporte;
import static controladores.mainController.bord;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Gherni
 */
public class SidebarController implements Initializable {

    @FXML
    private Label nombre;
    @FXML
    private Label apellido;
    @FXML
    private Label tablero;
    @FXML
    private Label main;
    @FXML
    private Label sadi;
    @FXML
    private Label transporte;
    @FXML
    private Label generacion;
    @FXML
    private Label distribucion;
    @FXML
    private Label agentes;
    @FXML
    private Label historicos;
    @FXML
    private Label fotae;
    @FXML
    private Label resumen;
    @FXML
    private Label calculos;
    @FXML
    private Label cerrar;
    @FXML
    private HBox btnTablero;
    @FXML
    private HBox btnSadi;
    @FXML
    private HBox btnTransporte;
    @FXML
    private HBox btnGeneracion;
    @FXML
    private HBox btnDistribucion;
    @FXML
    private HBox btnAgentes;
    @FXML
    private HBox btnHistoricos;
    @FXML
    private HBox btnFotaecaf;
    @FXML
    private HBox btnResumen;
    @FXML
    private HBox btnCalculos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void mouseHandle(MouseEvent event) {
        if(event.getSource()==btnTablero){
//            System.out.println("tablero");
            bord.setCenter(pTablero);
        }else if(event.getSource()==btnSadi){
//            System.out.println("sadi");
            bord.setCenter(pSadi);
        }else if(event.getSource()==btnTransporte){
//            System.out.println("transp");
            bord.setCenter(pTransporte);
        }else if(event.getSource()==btnGeneracion){
//            System.out.println("gene");
            bord.setCenter(pGeneracion);
        }else if(event.getSource()==btnDistribucion){
//            System.out.println("distr");
            bord.setCenter(pDistribucion);
        }else if(event.getSource()==btnAgentes){
//            System.out.println("age");
            bord.setCenter(pAgentes);
        }else if(event.getSource()==btnHistoricos){
////            System.out.println("hist");
            bord.setCenter(pHistoricos);
        }else if(event.getSource()==btnFotaecaf){
////            System.out.println("fotae");
            bord.setCenter(pFotae);
        }else if(event.getSource()==btnResumen){
//            System.out.println("res");
            bord.setCenter(pResumen);
        }else if(event.getSource()==btnCalculos){
//            System.out.println("calc");
            bord.setCenter(pCalculos);
        }
        
    }
    
}
