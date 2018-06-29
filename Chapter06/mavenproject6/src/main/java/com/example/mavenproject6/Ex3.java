/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mavenproject6;

import java.util.ArrayList;
import java.util.List;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

/**
 *
 * @author abdalla
 */
public class Ex3 {

    public static void main(String[] args) {
//        JsonbConfig config = new JsonbConfig().withStrictIJSON(true);

Movie movie1 = new Movie();
movie1.setId(15);
movie1.setTitle("Beauty and The Beast");

Movie movie2 = new Movie();
movie2.setId(16);
movie2.setTitle("The Boss Baby");

Movie movie3 = new Movie();
movie3.setId(17);
movie3.setTitle("Suicide Squad");

List<Movie> movies = new ArrayList<>();
movies.add(movie1);
movies.add(movie2);
movies.add(movie3);

Jsonb jsonb = JsonbBuilder.create();
jsonb.toJson(jsonb);

String json = jsonb.toJson(movies);
System.out.println(json);

    }
}
