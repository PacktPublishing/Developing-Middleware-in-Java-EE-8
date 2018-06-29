/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.io.IOException;
import java.util.HashMap;
import javax.websocket.EncodeException;
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
@ServerEndpoint(value = "/booking/{movieId}", encoders = {SeatsEncoder.class})
public class BookingEndpoint {

    // in-memory database for movies booking state
    private static final HashMap<Integer, boolean[][]> seatsDatabase = new HashMap<>();

    @OnOpen
    public void open(Session session, EndpointConfig conf, @PathParam("movieId") int movieId) {
        boolean[][] movieSeats = getMovieSeats(movieId);
        try {
            // remember which movieId this session is connected to
            session.getUserProperties().put("movieId", movieId);
            // send initial booking matrix state for this movie
            session.getBasicRemote().sendObject(movieSeats);
        } catch (EncodeException | IOException ex) {
            ex.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(Session session, String msg, @PathParam("movieId") int movieId) {
        // Retrieve the booking matrix for this movie
        boolean[][] movieSeats = getMovieSeats(movieId);

        if (msg.startsWith("book ")) {
            // a booking request from this user
            // extract seat index
            int seatIndex = Integer.parseInt(msg.substring(5));

            // identify its row and column in the booking matrix
            int row = seatIndex / movieSeats[0].length;
            int col = seatIndex % movieSeats[0].length;
            System.out.println("row " + row);
            System.out.println("col " + col);
            // set the status of this seat to be booked
            movieSeats[row][col] = true;

            // notify all users connected to this movie session
            // that this book has been booked
            for (Session openSession : session.getOpenSessions()) {
                if ((Integer) openSession.getUserProperties().get("movieId") != movieId) {
                    continue;
                }
                try {
                    openSession.getBasicRemote().sendText("booked " + seatIndex);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    /**
     * Retrieve the booking matrix for a specific movie
     *
     * @param movieId
     * @return
     */
    private boolean[][] getMovieSeats(int movieId) {
        // get the booking matrix for this movie
        boolean[][] movieSeats = seatsDatabase.get(movieId);
        // if it does not exist, create a newone
        if (movieSeats == null) {
            movieSeats = new boolean[14][12];
            seatsDatabase.put(movieId, movieSeats);
        }
        // return the booking matrix
        return movieSeats;
    }
}
