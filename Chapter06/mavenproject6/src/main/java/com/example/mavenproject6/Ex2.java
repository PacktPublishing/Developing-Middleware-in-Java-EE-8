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
public class Ex2 {

    public static void main(String[] args) {
//        JsonbConfig config = new JsonbConfig().withStrictIJSON(true);
String json = "{\"id\":15,\"title\":\"Beauty and The Beast\"}";
Jsonb jsonb = JsonbBuilder.create();

Movie movie = jsonb.fromJson(json, Movie.class);
System.out.println("Movie ID: " + movie.getId());
System.out.println("Movie Title: " + movie.getTitle());

    }
}
