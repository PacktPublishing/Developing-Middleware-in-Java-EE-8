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
public class Ex1 {

    public static void main(String[] args) {
//        JsonbConfig config = new JsonbConfig().withStrictIJSON(true);
Jsonb jsonb = JsonbBuilder.create();
jsonb.toJson(jsonb);

Movie movie = new Movie();
movie.setId(15);
movie.setTitle("Beauty and The Beast");

String json = jsonb.toJson(movie);
System.out.println(json);

    }
}
