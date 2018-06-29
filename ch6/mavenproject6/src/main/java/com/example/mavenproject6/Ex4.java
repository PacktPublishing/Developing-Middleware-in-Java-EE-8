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
public class Ex4 {

    public static void main(String[] args) {
//        JsonbConfig config = new JsonbConfig().withStrictIJSON(true);

String json = "[{\"id\":15,\"title\":\"Beauty and The Beast\"},{\"id\":16,\"title\":\"The Boss Baby\"},{\"id\":17,\"title\":\"Suicide Squad\"}]";
Jsonb jsonb = JsonbBuilder.create();

ArrayList<Movie> list = jsonb.fromJson(json, new ArrayList<Movie>(){}.getClass().getGenericSuperclass());

for (Movie movie : list) {
    System.out.println("Movie ID: " + movie.getId());
    System.out.println("Movie Name: " + movie.getTitle());
    System.out.println();
}

    }
}
