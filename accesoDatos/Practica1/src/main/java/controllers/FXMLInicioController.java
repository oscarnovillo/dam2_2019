/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FXMLInicioController implements Initializable {

    
    @FXML
    private BorderPane root;
    
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    private Alert a ;
    private AnchorPane pantalla1;
    private FXMLPantalla1Controller controllerPantalla1;
    
    private AnchorPane pantalla2;
    public FXMLPantalla2Controller controllerPantalla2;
    
    private void preCargarPantalla1(){
       
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantalla1.fxml"));
            pantalla1 = loaderMenu.load();
            controllerPantalla1
                    = loaderMenu.getController();

           controllerPantalla1.setRootController(this);
        } catch (IOException ex) {

            Logger.getLogger(FXMLInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }
    
    private void preCargarPantalla2(){
       
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLPantalla2.fxml"));
            pantalla2 = loaderMenu.load();
            controllerPantalla2
                    = loaderMenu.getController();

           // controllerPantalla1.setInicio(this);
        } catch (IOException ex) {

            Logger.getLogger(FXMLInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }
    public void pasarMensajePantalla2(String mensaje)
    {
        controllerPantalla2.mostrarMensaje(mensaje);
    }

    public void pasarMensajePantalla1(String mensaje)
    {
        controllerPantalla1.mostrarMensaje(mensaje);
    }

    
    public void cargarPantalla2(){
       root.setCenter(pantalla2);
    }
    
    public void cargarPantalla1(){
       root.setCenter(pantalla1);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        a  = new Alert(Alert.AlertType.INFORMATION);
        preCargarPantalla1();
        preCargarPantalla2();
    }    
    
}
