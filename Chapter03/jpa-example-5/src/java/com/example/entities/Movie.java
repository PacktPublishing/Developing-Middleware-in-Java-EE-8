/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQuery;

/**
 *
 * @author abdalla
 */
@Entity
@NamedQuery(name = "fetchMovie", query = "SELECT x FROM Movie x WHERE x.id=:id")
public class Movie {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    @ElementCollection
    @CollectionTable(name = "movie_genres", joinColumns =@JoinColumn(name = "movie_title", referencedColumnName = "title"))
    private List<String> genres = new ArrayList<>();

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

}
