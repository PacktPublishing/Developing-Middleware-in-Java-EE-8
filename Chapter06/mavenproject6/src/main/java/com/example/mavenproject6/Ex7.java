/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mavenproject6;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;

/**
 *
 * @author abdalla
 */
public class Ex7 {

    public static void main(String[] args) {
//        JsonbConfig config = new JsonbConfig().withStrictIJSON(true);
//String json = "{\"id\": 15,\"name\": \"Beauty and The Beast\"}";

JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.CASE_INSENSITIVE).withFormatting(true);
Jsonb jsonb = JsonbBuilder.create(config);

Movie movie = new Movie();
movie.setId(15);
movie.setTitle("Beauty and The Beast");
movie.setProductionYear(2017);

String json = jsonb.toJson(movie);
System.out.println(json);

    }
}
