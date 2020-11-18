package chatclient;

import chatclient.endpoint.SimpleEndpoint;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {


  @FXML
  private TextArea mensaje;
  @FXML
  private TextField user;
  @FXML
  private TextArea chat;

  private SimpleEndpoint ws;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

  @FXML
  private void conectar(ActionEvent actionEvent) {
    try {
      ws= new SimpleEndpoint(user.getText());
      ws.addMessageHandler(message -> tratarMensaje(message));
    } catch (URISyntaxException e) {
      e.printStackTrace();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (DeploymentException e) {
      e.printStackTrace();
    }


  }

  private void tratarMensaje(String mensaje)
  {
    chat.setText(chat.getText()+"\n"+mensaje);
  }

  @FXML
  private void mandar(ActionEvent actionEvent) {
    ws.sendMessage(mensaje.getText());
  }

  @FXML
  private void desconectar(ActionEvent actionEvent) {
    try {
      ws.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
