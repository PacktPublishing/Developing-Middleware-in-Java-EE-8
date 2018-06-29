/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example9;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author abdalla
 */
@Dependent
public class AnotherPojo {

    private MyPojo myPojo;

    @Inject
    public AnotherPojo(MyPojo myPojo) {
        this.myPojo = myPojo;
    }

    public String getMessage() {
        return myPojo.getMessage();
    }
}
