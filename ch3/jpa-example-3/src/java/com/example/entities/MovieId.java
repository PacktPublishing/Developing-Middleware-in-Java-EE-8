/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entities;

import javax.persistence.Embeddable;

/**
 *
 * @author abdalla
 */
@Embeddable
public class MovieId {

    private String title;
    private int productionYear;

    public MovieId() {
    }

    public MovieId(String title, int productionYear) {
        this.title = title;
        this.productionYear = productionYear;
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
