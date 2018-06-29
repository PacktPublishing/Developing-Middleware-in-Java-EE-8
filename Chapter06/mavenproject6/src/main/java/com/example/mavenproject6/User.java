/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mavenproject6;

import java.math.BigDecimal;
import java.util.Date;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbNumberFormat;

/**
 *
 * @author abdalla
 */
public class User {

    private long id;
    private String name;
    @JsonbDateFormat("dd/MM/yyy")
    private Date birthDate;
    @JsonbDateFormat("dd/MM/yyy hh:mm a")
    private Date lastLoggedIn;
    @JsonbNumberFormat("#0.00")
    private BigDecimal averageLoggedInTime;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public BigDecimal getAverageLoggedInTime() {
        return averageLoggedInTime;
    }

    public void setAverageLoggedInTime(BigDecimal averageLoggedInTime) {
        this.averageLoggedInTime = averageLoggedInTime;
    }

}
