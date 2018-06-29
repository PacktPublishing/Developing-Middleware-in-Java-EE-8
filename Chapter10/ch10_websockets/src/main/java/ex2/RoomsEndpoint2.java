/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RoomsEndpoint2 {

    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig,
            @PathParam("roomName") String roomName,
            @PathParam("username") String username) {
        // set room name and username in the properties map
        session.getUserProperties().put("roomName", roomName);
        session.getUserProperties().put("username", username);
        // send all other user names in the same room to this user
        for (Session openSession : session.getOpenSessions()) {
            String room = (String) openSession.getUserProperties().get("roomName");
            // if user in the same room
            if (room.equals(roomName)) {
                String user = (String) openSession.getUserProperties().get("username");
                try {
                    // send the username to this user
                    session.getBasicRemote().sendText(user);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }
}
