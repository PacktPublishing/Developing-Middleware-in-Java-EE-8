/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author abdalla
 */
public class MovieEncoder implements Encoder.Text<Movie> {

    @Override
    public String encode(Movie movie) throws EncodeException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(jsonb);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
    }

    @Override
    public void destroy() {
    }

}
