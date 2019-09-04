/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;


/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLPagina2Controller implements Initializable {

  @FXML
  private ComboBox fxComboDatos;

  private FXMLBorderPaneController principalController;

  public void setPrincipalController(FXMLBorderPaneController principalController) {
    this.principalController = principalController;
  }

  @FXML
  public void changeCombo(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
   
    alert.setTitle("Information Dialog");
    alert.setHeaderText(null);
    alert.setContentText("Seleccion de combo "
	    + fxComboDatos.getSelectionModel().getSelectedItem());

    alert.showAndWait();

  }

  public void addCombo(Object o) {
    fxComboDatos.getItems().add(o);
  }
 
  public void addCombo(Collection c) {
    fxComboDatos.getItems().addAll(c);
  }

  @FXML
  public void clickBoton(ActionEvent event) {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.getDialogPane().lookupButton(ButtonType.OK)
            .setId("hola");
    alert.setHeaderText(null);
    alert.setContentText("Hola desde Pag 2"
	    + principalController.getNombre());
   // alert.getDialogPane().getContent().setId("texto");

    alert.showAndWait();

    ArrayList<String> strings = new ArrayList<>();

    strings.add("uno");
    strings.add("dos");
    strings.add("tres");

    fxComboDatos.getItems().addAll(strings);

  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}
