package encoders;

import com.datoshttp.Mensaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MensajeEncoder implements Encoder.Text<Mensaje>{
  @Override
  public String encode(Mensaje mensaje) throws EncodeException {
    ObjectMapper mapper = new ObjectMapper();
    String text="";
    try {
      text = mapper.writeValueAsString(mensaje);
    } catch (JsonProcessingException e) {
      throw new EncodeException(mensaje,text,e);
    }
    return text;
  }

  @Override
  public void init(EndpointConfig endpointConfig) {

  }

  @Override
  public void destroy() {

  }
}
