package encoders;

import com.datoshttp.MetaMensajeWS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MetaMensajeDecoder implements Decoder.Text<MetaMensajeWS> {

  @Override
  public MetaMensajeWS decode(String mensaje) throws DecodeException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    MetaMensajeWS meta;
    try {
      meta = mapper.readValue(mensaje,
          new TypeReference<MetaMensajeWS>() {
          });
    } catch (JsonProcessingException e) {
      throw new DecodeException("","",e);
    }
    return meta;
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
