/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package chatclient.endpoint;


import com.datoshttp.Mensaje;
import com.datoshttp.MetaMensajeWS;
import com.datoshttp.OrdenRoomsWS;
import com.datoshttp.TipoMensaje;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import encoders.MensajeDecoder;
import encoders.MetaMensajeEncoder;
import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arun Gupta
 */

@ClientEndpoint(configurator = ClientEndPointConfig.class,
encoders = MetaMensajeEncoder.class,
decoders = MensajeDecoder.class)
public class MyClient {

    private Session userSession;
    private MessageListener messageHandler;
    
    public MyClient(URI endpointURI, String sessionId) {
         try {
            final ClientEndpointConfig cec;
            
            cec = ClientEndpointConfig.Builder.create().configurator(new ClientEndpointConfig.Configurator() { 
            @Override
            public void beforeRequest(Map<String, List<String>> headers) {
             
                super.beforeRequest(headers);
                             //String sessionId = login();
                             List cookieList = headers.get("Cookie");
                             if (cookieList == null) cookieList = new ArrayList();
                             cookieList.add("JSESSIONID=\""+sessionId+"\"");
                             headers.put("Cookie", cookieList);

            }


        }).build(); 
            
            ClientManager client = ClientManager.createClient();
            client.connectToServer (this,endpointURI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
  
    @OnOpen
    public void onOpen(Session session, EndpointConfig ec) {
       this.userSession = session;

       //session.addMessageHandler((MessageHandler.Whole<String>) message -> processMessage(message));
        System.out.println("Connected to endpoint: " + session.getBasicRemote());
    }
    
    
    public void addMessageHandler(final MessageListener msgHandler) {
        messageHandler = msgHandler;
    }

    public void sendMessage(Mensaje message) {
        try {
            //ObjectMapper mapper = new ObjectMapper();
            MetaMensajeWS ms = new MetaMensajeWS();
            ms.setTipo(TipoMensaje.MENSAJE);
            ms.setContenido(message);
            //String men = mapper.writeValueAsString(ms);
            
            //encriptar el men con la key
            
            userSession.getAsyncRemote().sendObject(ms);
        } catch (Exception ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void sendOrden(OrdenRoomsWS orden) {
        try {

            MetaMensajeWS ms = new MetaMensajeWS();
            ms.setTipo(TipoMensaje.ORDEN);
            ms.setContenido(orden);
          //ObjectMapper mapper = new ObjectMapper();
            //String men = mapper.writeValueAsString(ms);
            userSession.getAsyncRemote().sendObject(ms);
        } catch (Exception ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @OnMessage
    public void processMessage(Mensaje message) {
      System.out.println(message);
        if (messageHandler != null) {
//            try {
//                ObjectMapper mapper = new ObjectMapper();
//                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//                Mensaje mensaje = mapper.readValue(message,
//                        new TypeReference<Mensaje>() {
//                });

                messageHandler.handleMessage(message);
//            } catch (IOException ex) {
//                Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }





  public static interface MessageListener {

        public void handleMessage(Mensaje message);
    }
    
}
