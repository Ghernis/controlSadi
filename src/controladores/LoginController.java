/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import IO.escribirBinario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import objetos.usuarios;

/**
 * FXML Controller class
 *
 * @author Gherni
 */
public class LoginController implements Initializable {

    @FXML
    private Label welcome;
    @FXML
    private Label by;
    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXButton btnLog;
    @FXML
    private JFXButton btnCont;
    @FXML
    private Label info;
    @FXML
    private Label forgot;
    @FXML
    private Label Login;
    @FXML
    private Label frase2;
    @FXML
    private Label frase1;
    private double xOffset=0,yOffset=0;
    @FXML
    private AnchorPane parent;
    @FXML
    private JFXPasswordField txtPassword;
    /**
     * Initializes the controller class.
     */
    usuarios[] users;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();
        escribirBinario es = new escribirBinario("users.ext");
        users = es.leerBinPC();
        // TODO
    }    
    private void makeStageDragable(){
        parent.setOnMousePressed((event)->{
        xOffset=event.getSceneX();
        yOffset=event.getSceneY();
    });
        parent.setOnMouseDragged((event)->{
        Launch.stage.setX(event.getScreenX()-xOffset);
        Launch.stage.setY(event.getScreenY()-yOffset);
        Launch.stage.setOpacity(0.8f);
        });
        parent.setOnDragDone((event)->{
           Launch.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((event)->{
        Launch.stage.setOpacity(1.0f);
        });
    }

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleButton(ActionEvent event) {
//        ControlSadi.stage.close();
        Launch.stage.setScene(Launch.rootScene);
        Launch.stage.centerOnScreen();
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String user = txtUsuario.getText();
        String pass = txtPassword.getText();
//        System.out.println("us: "+user+" Pass: "+pass);
        boolean sentinel =true;
        boolean status = false;
        int cont = 0;
        do{
            if(users[cont].getUsuario().equals(user)){
                sentinel=false;
                status = true;
            }
            else{
                cont++;
                if(cont==users.length){
                    sentinel = false;
                }
                
            }
            
        }while(sentinel);
        if (status) {
            System.out.println("te logeaste como "+users[cont].getNombre());
            Launch.stage.setScene(Launch.rootScene);
            Launch.stage.centerOnScreen();
        }
        else{
            System.out.println("No te logeaste nada");
        }
    }
    
}
