package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author oscar
 */
public class FXMLPantalla2Controller implements Initializable {

    private FXMLInicioController rootController;

    public void setRootController(FXMLInicioController rootController) {
        this.rootController = rootController;
    }

    
    @FXML
    private TextField fxTextMensaje;
    
    public void irPantalla1(){
        rootController.cargarPantalla1();
        rootController.pasarMensajePantalla1(fxTextMensaje.getText());

    }
    
    public void mostrarMensaje(String mensaje){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(mensaje);
        a.showAndWait();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
