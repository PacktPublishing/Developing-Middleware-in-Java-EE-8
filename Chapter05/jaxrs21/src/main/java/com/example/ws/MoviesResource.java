/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ws;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author abdalla
 */
@Path("movies")
public class MoviesResource {

    private static Map<Long, Movie> moviesDB = new HashMap<>();

    static {
        moviesDB.put(11L, new Movie(11, "Beauty and the Beast"));
        moviesDB.put(12L, new Movie(12, "Suicide Squade"));
    }

    public MoviesResource() {
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie getById(@PathParam("id") long id) {
        return moviesDB.get(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Movie> listMovies() {
        return moviesDB.values();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void modifyById(@PathParam("id") long id, Movie movie) {
        if (!moviesDB.containsKey(id)) {
            throw new RuntimeException("No movie with such id found!");
        }
        moviesDB.put(id, movie);
    }

    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMovie(@PathParam("id") long id, Movie movie) {
        if (moviesDB.containsKey(id)) {
            throw new RuntimeException("A movie with such id already exists!");
        }
        moviesDB.put(id, movie);
    }
}
