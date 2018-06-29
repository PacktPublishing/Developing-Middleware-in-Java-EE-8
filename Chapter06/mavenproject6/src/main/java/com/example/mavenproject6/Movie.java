/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mavenproject6;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbTransient;

/**
 *
 * @author abdalla
 */
@JsonbNillable
public class Movie {

    private long id;
    private String title;
    private int productionYear;

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

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

}
