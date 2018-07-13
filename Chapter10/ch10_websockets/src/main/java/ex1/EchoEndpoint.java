/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.IOException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author abdalla
 */
@ServerEndpoint("/echo")
public class EchoEndpoint {

    @OnMessage
    public void onMessage(Session session, String msg) {
        System.out.println("Message received: " + msg);

        String response = "You sent: " + msg;
        try {
            session.getBasicRemote().sendText(response);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
