/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mavenproject6;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

/**
 *
 * @author abdalla
 */
public class Ex6 {

    public static void main(String[] args) {
//        JsonbConfig config = new JsonbConfig().withStrictIJSON(true);
    String json = "{\"id\": 15,\"name\": \"Beauty and The Beast\"}";

    JsonbConfig config = new JsonbConfig().withFormatting(true);
    Jsonb jsonb = JsonbBuilder.create(config);

    Movie movie = jsonb.fromJson(json, Movie.class);
    String toJson = jsonb.toJson(movie);
    System.out.println(toJson);

    }
}
