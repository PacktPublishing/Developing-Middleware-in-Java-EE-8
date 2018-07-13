/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example6;

import javax.enterprise.context.Dependent;

/**
 *
 * @author abdalla
 */
@Dependent
public class MyPojo {

    @Logged
    public String getMessage1() {
        return "MyPojo first message!";
    }

    public String getMessage2() {
        return "MyPojo second message!";
    }
}
