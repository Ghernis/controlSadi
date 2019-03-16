/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Gherni
 */
public class mainController implements Initializable{
    public static BorderPane bord;
    @FXML BorderPane border;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        bord=border;
        try{
           Parent sidebar = FXMLLoader.load(getClass().getResource("/views/sidebar.fxml"));
           Parent tablero = FXMLLoader.load(getClass().getResource("/views/FXMLDocument.fxml"));
           Parent sadi = FXMLLoader.load(getClass().getResource("/views/sadi.fxml"));
           Parent transporte = FXMLLoader.load(getClass().getResource("/views/transporte.fxml"));
           Parent generacion = FXMLLoader.load(getClass().getResource("/views/generacion.fxml"));
           Parent distribucion = FXMLLoader.load(getClass().getResource("/views/distribucion.fxml"));
           Parent agentes = FXMLLoader.load(getClass().getResource("/views/agentes.fxml"));
           Parent historicos = FXMLLoader.load(getClass().getResource("/views/hitoricos.fxml"));
           Parent fotae = FXMLLoader.load(getClass().getResource("/views/fotaecaf.fxml"));
           Parent resumen = FXMLLoader.load(getClass().getResource("/views/resumenMensual.fxml"));
           Parent calculos = FXMLLoader.load(getClass().getResource("/views/calculos.fxml"));
           
           
//           border.setCenter(sadi);
           border.setCenter(tablero);
           border.setLeft(sidebar);
           
        }
        catch(IOException ex){
            System.out.println("Exception: "+ex);
        }
    }

    
}
