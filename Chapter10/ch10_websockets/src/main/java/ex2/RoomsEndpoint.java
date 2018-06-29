/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author abdalla
 */
@ServerEndpoint("/rooms/{roomName}/{username}")
public class RoomsEndpoint {

    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig,
            @PathParam("roomName") String roomName,
            @PathParam("username") String username) {
        System.out.println("room " + roomName);
        System.out.println("user " + username);
    }
}
