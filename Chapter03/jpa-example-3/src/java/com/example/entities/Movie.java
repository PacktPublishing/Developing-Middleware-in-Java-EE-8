/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author abdalla
 */
@Entity
public class Movie {

    @EmbeddedId
    private MovieId movieId;

    public Movie() {
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public void setMovieId(MovieId movieId) {
        this.movieId = movieId;
    }

}
