/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLPrimeraPantallaController implements Initializable {
  
  @FXML
  private TextField fxTxtNombre;
  
  private FXMLBorderPaneController borderPane;
  
  public void setBorderPane(FXMLBorderPaneController borderPane) {
    this.borderPane = borderPane;
  }
  
  @FXML
  public void clickBoton(ActionEvent event) {
    
    borderPane.setNombre(fxTxtNombre.getText());
    borderPane.getPag2Controller().addCombo(fxTxtNombre.getText());
    borderPane.cargarPag2();
  }
  
  public void resetear() {
    fxTxtNombre.setText(null);
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
    fxTxtNombre.setPromptText("lo he cambiado por codigo");
  }
  
}
