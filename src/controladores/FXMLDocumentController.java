/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controlPane.JsonReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.json.JSONObject;

/**
 *
 * @author Gherni
 */
public class FXMLDocumentController implements Initializable {
    public static AnchorPane pTablero;
    private Label label;
    @FXML
    private AnchorPane pnTablero;
    @FXML
    private Label lbPrecioD;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pTablero = pnTablero;
        try{
        JsonReader jr = new JsonReader();
        JSONObject jsonOb = jr.readJsonFromUrl("http://data.fixer.io/api/latest?access_key=c4956addde6c5ba59c397f8d1af65ff0&format=1&symbols=USD,ARS,GBP,CNY");
        lbPrecioD.setText(jsonOb.toString());
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }
//    System.out.println(json.toString());
        
    }    
    
}
