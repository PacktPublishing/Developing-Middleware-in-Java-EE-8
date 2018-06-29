/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;

/**
 *
 * @author abdalla
 */
public class MovieDecoder implements Decoder.Text<Movie> {

    @Override
    public Movie decode(String movieJson) throws DecodeException {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.fromJson(movieJson, Movie.class);
    }

    @Override
    public boolean willDecode(String movieJson) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
    }

    @Override
    public void destroy() {
    }

}
