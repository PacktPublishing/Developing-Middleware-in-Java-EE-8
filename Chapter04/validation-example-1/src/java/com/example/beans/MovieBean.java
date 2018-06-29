/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import com.example.entities.Actor;
import com.example.entities.Movie;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author abdalla
 */
@Transactional
@RequestScoped
public class MovieBean {

    @PersistenceContext(name = "jpa-examplesPU")
    private EntityManager entityManager;
    @Inject
    private Validator validator;

    public void foo() {

Movie movie = new Movie();
movie.setTitle("tEST MORE THAN 10");

Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
Set<ConstraintViolation<Movie>> violations = validator.validate(movie);
for (ConstraintViolation<Movie> violation : violations) {
    System.out.println(violation.getPropertyPath());
    System.out.println(violation.getMessage());
}
    }

    @NotNull
    public String foo2(@NotNull String something) {
        System.out.println("===========================");
        System.out.println("SOMETHING");
        return null;
    }
}
