/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import ex3.SeatsEncoder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author abdalla
 */
@ServerEndpoint(value = "/movie/{movieId}", 
        encoders = {MovieEncoder.class},     
        decoders = {MovieDecoder.class})
public class MoviesEndpoint{
    
    
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        Movie movie = new Movie();
        try {
            // fill with some data
            session.getBasicRemote().sendObject(movie);
        } catch (IOException | EncodeException ex) {
            ex.printStackTrace();
        }
    }
    
}