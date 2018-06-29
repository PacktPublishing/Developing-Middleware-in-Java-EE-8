/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import com.example.entities.Movie;
import com.example.entities.Producer;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author abdalla
 */
@RequestScoped
@Transactional
public class MovieBean {

    @PersistenceContext(name = "jpa-examplesPU")
    private EntityManager entityManager;

    public void foo() {

Query q = entityManager.createNativeQuery("SELECT m.title, m.producer FROM Movie m", Movie.class);
List<Movie> movies = q.getResultList();

for (Movie movie : movies) {
    System.out.println("(Movie) title:" + movie.getTitle() + ", producer:" + movie.getProducer().getName());
}
//        Query query = entityManager.createQuery("SELECT m FROM Movie m WHERE m.title=:title");
//        query.setParameter("title", "Beauty and the Beast");
//        Movie movie = (Movie) query.getSingleResult();

//Query query = entityManager.createQuery("SELECT p FROM Producer p WHERE p.name=:name");
//query.setParameter("name", "Walt Disney");
//Producer producer = (Producer) query.getSingleResult();
//        Movie movie = new Movie();
//        movie.setTitle("Beauty and the Beast");
//        movie.setProducer(producer);
//        entityManager.persist(movie);
//Query query = entityManager.createQuery("SELECT m FROM Movie m");
//List<Query> results = query.getResultList();
//
//        
//Movie m = entityManager.find(Movie.class, 1);
    }

    public void insert(Movie movie) {
        entityManager.persist(movie);
    }

}
