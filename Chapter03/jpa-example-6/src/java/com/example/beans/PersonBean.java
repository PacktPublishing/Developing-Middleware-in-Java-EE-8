/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import com.example.entities.Actor;
import com.example.entities.Director;
import com.example.entities.Person;
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
public class PersonBean {

    @PersistenceContext(name = "jpa-examplesPU")
    private EntityManager entityManager;

    public void foo() {
        Actor a = entityManager.getReference(Actor.class, 1L);
        System.out.println(a.getName());
        a.setName("Abdalla Mahmoud");
        if (true) {
            return;
        }
        Query query = entityManager.createQuery("SELECT x FROM Person x WHERE x.name like :name AND type(x) in (Actor, Director)");
        query.setParameter("name", "John%");
        List<Person> results = query.getResultList();
        System.out.println("==============");
        for (Person result : results) {
            if (result instanceof Actor) {
                Actor actor = (Actor) result;
                System.out.println("An acotr found with name " + actor.getName());
            } else if (result instanceof Director) {
                Director director = (Director) result;
                System.out.println("A director found with name " + director.getName());
            }
        }
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//
//            Actor actor = new Actor();
//            actor.setName("Emma Watson");
//            actor.setBiography("Born in Paris, France.");
//            actor.setBirthDate(sdf.parse("04/15/1990"));
//            entityManager.persist(actor);
//
//            Director director = new Director();
//            director.setName("Bill Condon");
//            director.setBirthDate(sdf.parse("10/22/1955"));
//            director.setDir("Born in New York.");
//            entityManager.persist(director);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//        }
    }
}
