package chatclient.endpoint;

import com.datoshttp.Mensaje;
import com.datoshttp.MetaMensajeWS;
import com.datoshttp.TipoMensaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;


@ClientEndpoint
public class SimpleEndpoint {

  private Session userSession;
  private SimpleMessageListener messageHandler;
  private String user;

  public SimpleEndpoint(String user) throws URISyntaxException, IOException, DeploymentException {

    this.user = user;
    conectar();
  }

  @OnClose
  public void close() throws IOException {
    userSession.close();
  }

  private void conectar() throws URISyntaxException, IOException, DeploymentException {


    ClientManager client = ClientManager.createClient();
    client.connectToServer(this,new URI("ws://localhost:8080/payara/simple?user="+user));
  }


  @OnOpen
  public void onOpen(Session session, EndpointConfig endpointConfig) {
    this.userSession = session;
   // session.addMessageHandler((MessageHandler.Whole<String>) message -> processMessage(message));
  }

  public void addMessageHandler(final SimpleMessageListener msgHandler) {
    messageHandler = msgHandler;
  }

  @OnMessage
  public void processMessage(String message) {
    if (messageHandler != null) {
      messageHandler.handleMessage(message);
    }
  }


  public void sendMessage(String message) {

      userSession.getAsyncRemote().sendText(message);
  }

  public interface SimpleMessageListener {

    public void handleMessage(String message);
  }
}
