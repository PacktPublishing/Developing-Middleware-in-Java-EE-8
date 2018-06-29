/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example3;

import javax.enterprise.context.Dependent;


/**
 *
 * @author abdalla
 */
@Dependent
@AnotherImp
public class AnotherPojoImp implements MyPojo{

    @Override
    public String getMessage() {
        return "Hello CDI 2.0 from AnotherPojoImp";
    }
}
