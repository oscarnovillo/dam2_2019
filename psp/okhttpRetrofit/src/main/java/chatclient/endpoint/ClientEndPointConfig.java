package chatclient.endpoint;

import chatclient.PequeChatFrame;

import javax.websocket.ClientEndpointConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ClientEndPointConfig extends ClientEndpointConfig.Configurator {

  @Override
  public void beforeRequest(Map<String, List<String>> headers) {
    super.beforeRequest(headers);
    //String sessionId = login();
    List cookieList = headers.get("Cookie");
    if (cookieList == null) cookieList = new ArrayList();
    cookieList.add("JSESSIONID=\""+ PequeChatFrame.jsessionId+"\"");
    headers.put("Cookie", cookieList);
    headers.put("Authorization", Arrays.asList("bearer: "+PequeChatFrame.jsessionId));

  }
}
