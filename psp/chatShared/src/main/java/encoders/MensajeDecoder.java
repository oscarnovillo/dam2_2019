package encoders;

import com.datoshttp.Mensaje;
import com.datoshttp.MetaMensajeWS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MensajeDecoder implements Decoder.Text<Mensaje> {
  @Override
  public Mensaje decode(String message) throws DecodeException {
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Mensaje mensaje;
    try {
      mensaje = mapper.readValue(message,
          new TypeReference<Mensaje>() {
          });
    } catch (JsonProcessingException e) {
      throw new DecodeException(message,message,e);
    }

    return mensaje;
  }

  @Override
  public boolean willDecode(String s) {
    return true;
  }


  @Override
  public void init(EndpointConfig endpointConfig) {

  }

  @Override
  public void destroy() {

  }
}
