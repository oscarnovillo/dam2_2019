package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.ConstantesFxml;

public class MainFX extends Application {


  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loaderMenu = new FXMLLoader(
        getClass().getResource(ConstantesFxml.FXML_PANTALLA_INICIO_FXML));
    BorderPane root = loaderMenu.load();
    Scene scene = new Scene(root);
    primaryStage.setTitle("IES Quevedo");
    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setResizable(false);
  }

}
