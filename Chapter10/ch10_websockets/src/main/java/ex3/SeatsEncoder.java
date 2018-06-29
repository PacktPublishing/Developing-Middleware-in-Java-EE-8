/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author abdalla
 */
public class SeatsEncoder implements Encoder.Text<boolean[][]> {

    @Override
    public String encode(boolean[][] seats) throws EncodeException {
        StringBuilder sb = new StringBuilder();
        sb.append("seats ");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                sb.append(seats[i][j] ? "1" : "0");
            }
            if (i != seats.length - 1) {
                sb.append("|");
            }
        }

        return sb.toString();

    }

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

}
