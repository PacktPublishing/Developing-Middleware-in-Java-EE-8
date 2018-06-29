/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example1;

import javax.enterprise.context.Dependent;

/**
 *
 * @author abdalla
 */
@Dependent
public class MyPojo {

    public String getMessage() {
        return "Hello from MyPojo !";
    }
}
