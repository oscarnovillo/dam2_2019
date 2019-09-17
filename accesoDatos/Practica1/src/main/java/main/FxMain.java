/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.ConfigurationProperties;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author dam2
 */
public class FxMain extends Application {

    

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loaderMenu = new FXMLLoader(
                getClass().getResource("/fxml/FXMLInicio.fxml"));
        BorderPane root = loaderMenu.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("IES Quevedo");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
        //ConfigurationProperties c = new ConfigurationProperties();
        
        System.out.println(ConfigurationProperties.getInstance().getClave());
        System.out.println(ConfigurationProperties.getInstance().getP().getProperty("claves"));
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
