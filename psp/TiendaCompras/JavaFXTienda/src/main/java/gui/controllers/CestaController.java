package gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import servicios.SvProductos_cliente;
import utils.Constantes;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CestaController implements Initializable {
    private Alert alert;
    private SvProductos_cliente sv_productos;
    private PrincipalController principalController;
    @FXML
    private ListView viewProductosCesta;

    public void setPrincipalController(PrincipalController principalController) {
        this.principalController = principalController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        sv_productos = new SvProductos_cliente();
    }

    @FXML
    private void clickComprar(ActionEvent actionEvent) {
        String buy = sv_productos.buyCesta(viewProductosCesta.getItems());
        if (buy.equals(Constantes.COMPRA_EXITOSA)) {
            //Tengo que limpiar tanto view como lista global
            viewProductosCesta.getItems().clear();
            principalController.setCesta(null);
        }
        alert.setContentText(buy);
        alert.showAndWait();
    }

    @FXML
    private void clickVaciar(ActionEvent actionEvent) {
        String clear = sv_productos.clearCesta(viewProductosCesta.getItems());
        if (viewProductosCesta.getItems() != null) {
            viewProductosCesta.getItems().clear();
            principalController.setCesta(null);
        }
        alert.setContentText(clear);
        alert.showAndWait();
    }

    @FXML
    private void clickVolver(ActionEvent actionEvent) {
        principalController.clickProductos();
    }

    public void cargaViewCesta(List productosCesta) {
        viewProductosCesta.getItems().clear();
        if (productosCesta != null) {
            viewProductosCesta.getItems().addAll(productosCesta);
        } else {
            viewProductosCesta.getItems().addAll("NO hay productos en la cesta");
        }
    }
}
