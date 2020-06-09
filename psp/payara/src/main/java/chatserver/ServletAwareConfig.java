/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 *
 * @author oscar
 */
public class ServletAwareConfig extends
    ServerEndpointConfig.Configurator{
   

    @Override
    public void modifyHandshake(ServerEndpointConfig config,
                                HandshakeRequest request,
                                HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        String cabe = request.getHeaders().get("Authorization").get(0);
        String jwt = cabe.substring(7);
        //comprobar jwt.


        config.getUserProperties().put("httpsession",httpSession );

    }

}
