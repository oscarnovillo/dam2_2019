package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaInicioTest implements Initializable {

  public MenuItem fxMenuClose;

  public void test(ActionEvent actionEvent) {
  }

  public void menuClose(ActionEvent actionEvent) {
    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
    a.showAndWait();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    fxMenuClose.setText("jjjj");
  }
}
