import com.datoshttp.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import encoders.MensajeDecoder;
import encoders.MensajeEncoder;
import encoders.MetaMensajeDecoder;
import encoders.MetaMensajeEncoder;

import javax.websocket.DecodeException;
import javax.websocket.EncodeException;

public class MainTest {

  public static void main(String[] args) throws EncodeException, DecodeException, JsonProcessingException {
    MensajeDecoder md = new MensajeDecoder();
    MensajeEncoder me = new MensajeEncoder();
    MetaMensajeDecoder mmd = new MetaMensajeDecoder();
    MetaMensajeEncoder mme = new MetaMensajeEncoder();

    MetaMensajeWS ms = new MetaMensajeWS();
    OrdenRoomsWS or = new OrdenRoomsWS();
    or.setOrden("pp");
    or.setRoom("room");
    ms.setContenido(or);
    ms.setTipo(TipoMensaje.ORDEN);
    Mensaje m = new Mensaje();
    m.setFrom("from");
    m.setMensaje("mensaje");
    m.setRoom("room");
ms.setContenido(m);

    System.out.println();
    String s = mme.encode(ms);
    System.out.println(s);
    ms = mmd.decode(s);

    System.out.println(s);


  }
}
