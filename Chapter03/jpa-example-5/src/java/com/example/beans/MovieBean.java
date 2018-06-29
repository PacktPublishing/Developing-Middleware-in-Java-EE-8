/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import com.example.entities.Movie;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        Query query = entityManager.createQuery("SELECT m FROM Movie m");
        List<Query> results = query.getResultList();

        Movie m = entityManager.find(Movie.class, 1);
    }

    public void insert(Movie movie) {
        entityManager.persist(movie);
    }

    public Movie test() {
//        Query q = entityManager.createNamedQuery("fetchMovie");
//        q.setParameter("id", 1);
//        return (Movie) q.getSingleResult();
CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Movie> q = entityManager.getCriteriaBuilder().createQuery(Movie.class);
Root<Movie> root = q.from(Movie.class);
q.select(root);
q.where(cb.equal(root.get("id"), 1));

Movie movie = entityManager.createQuery(q).getSingleResult();
        return movie;
//Movie movie = entityManager.find(Movie.class, 1);
//movie.setTitle("Modified title");
//Movie movie = new Movie();
//movie.setId(1);
//movie.setTitle("Modified title");
//entityManager.merge(movie);
//        Movie movie = entityManager.find(Movie.class, 1);
//        entityManager.detach(movie);
//        movie.setTitle("Not mofiied title!");
////        entityManager.remove(this);
//        return movie;
    }

}
