/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import objetos.makeUsers;

/**
 *
 * @author Gherni
 */
public class Launch extends Application {
    public static Stage stage= null;
    public static Scene rootScene,loginScene;
    @FXML BorderPane border;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/main.fxml"));
        Parent login = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        rootScene = new Scene(root);
        loginScene = new Scene(login);
        rootScene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        loginScene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        stage.setScene(loginScene);
        
        this.stage = stage;
//        Font.loadFont(getClass().getResourceAsStream("/fonts/palanquin-medium.tff"),14);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {

        
        launch(args);
        
        
    }
    
}
