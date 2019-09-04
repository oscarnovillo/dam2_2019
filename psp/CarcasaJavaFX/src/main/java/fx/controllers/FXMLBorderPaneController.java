/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLBorderPaneController implements Initializable {

  @FXML
  private BorderPane fxRoot;

  private Alert alert;

  private String nombre;

  public String getNombre() {
    return nombre;
  }

  
  public String probando;
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  private AnchorPane pagPrincipal;
  private FXMLPrimeraPantallaController principalController;

  private AnchorPane pag2;
  private FXMLPagina2Controller pag2Controller;

  private AnchorPane abrirSobre;
  private FXMLAbrirSobreController abrirSobreController;

  public FXMLPagina2Controller getPag2Controller() {
    return pag2Controller;
  }

  @FXML
  public void cargar1(ActionEvent event) {

    cargarPrincipal();
  }

  public void cargarAbrirSobre() {
    try {
      if (abrirSobre == null) {
	FXMLLoader loaderMenu
		= new FXMLLoader(getClass().getResource("/fxml/FXMLAbrirSobre.fxml"));
	abrirSobre = loaderMenu.load();

	abrirSobreController = loaderMenu.getController();
	abrirSobreController.setPrincipalController(this);
	ArrayList<String> niños = new ArrayList<>();
	niños.add("j");
	niños.add("p");
	niños.add("k");
	abrirSobreController.cargarNiñatos(niños);
      }

      fxRoot.setCenter(abrirSobre);

    } catch (Exception ex) {
      Logger.getLogger(FXMLBorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public ArrayList<String> dameAlbumsNiñato(String niño) {
    ArrayList<String> albums = new ArrayList<>();
    switch (niño) {
      case "j":
	albums.add("1");
	break;
      case "p":
	albums.add("3");
	break;
      default:
	albums.add("2");
    }

    return albums;
  }

  public void cargarPrincipal() {
    try {
      if (pagPrincipal == null) {
	FXMLLoader loaderMenu
		= new FXMLLoader(getClass().getResource("/fxml/FXMLPrimeraPantalla.fxml"));
	pagPrincipal = loaderMenu.load();
	principalController = loaderMenu.getController();
	principalController.setBorderPane(this);
      }
      principalController.resetear();
      fxRoot.setCenter(pagPrincipal);

    } catch (Exception ex) {
      Logger.getLogger(FXMLBorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void preCargarPag2() {
    try {
      FXMLLoader loaderMenu
	      = new FXMLLoader(getClass().getResource("/fxml/FXMLPagina2.fxml"));
      pag2 = loaderMenu.load();
      pag2Controller = loaderMenu.getController();
      pag2Controller.setPrincipalController(this);
    } catch (Exception ex) {
      Logger.getLogger(FXMLBorderPaneController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void cargarPag2() {
    fxRoot.setCenter(pag2);
  }

  @FXML
  public void cargar2(ActionEvent event) {
    cargarPag2();

  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
    alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText(null);
    preCargarPag2();
    cargarPrincipal();
    probando  ="test";
  }

}
