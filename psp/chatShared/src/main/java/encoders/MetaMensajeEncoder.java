package encoders;

import com.datoshttp.MetaMensajeWS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MetaMensajeEncoder implements Encoder.Text<MetaMensajeWS>{

  @Override
  public String encode(MetaMensajeWS metaMensajeWS) throws EncodeException {
    ObjectMapper mapper = new ObjectMapper();
    String text="";
    try {
      text = mapper.writeValueAsString(metaMensajeWS);
    } catch (JsonProcessingException e) {
      throw new EncodeException(metaMensajeWS,text,e);
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
