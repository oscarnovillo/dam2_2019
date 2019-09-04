/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLAbrirSobreController implements Initializable {

  @FXML
  private ComboBox<String> fxComboNiñato;
  @FXML
  private ComboBox fxComboAlbum;

  private FXMLBorderPaneController principalController;

  public void setPrincipalController(FXMLBorderPaneController principalController) {
    this.principalController = principalController;
  }

  public void cargarNiñatos(ArrayList<String> niñatos) {
    fxComboNiñato.getItems().clear();
    fxComboNiñato.getItems().addAll(niñatos);
  }

  @FXML
  public void cambiaNiñato(ActionEvent event) {
    String seleccion
	    = fxComboNiñato.getSelectionModel()
		    .getSelectedItem();
    if (seleccion != null) {
      ArrayList<String> albums = principalController.dameAlbumsNiñato(seleccion);
      fxComboAlbum.getItems().clear();
      fxComboAlbum.getItems().addAll(albums);
    }
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO

  }

}
