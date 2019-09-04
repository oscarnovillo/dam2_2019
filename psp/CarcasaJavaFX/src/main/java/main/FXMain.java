/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author oscar
 */
public class FXMain extends Application {
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    
    FXMLLoader loaderMenu = 
	    new FXMLLoader(getClass().getResource("/fxml/FXMLBorderPane.fxml"));
    BorderPane root = loaderMenu.load();
    
    Scene scene = new Scene(root);
    
    primaryStage.setTitle("Carcasa FX");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
