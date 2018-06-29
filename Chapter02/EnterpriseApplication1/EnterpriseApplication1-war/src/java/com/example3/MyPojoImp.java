/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example3;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;


/**
 *
 * @author abdalla
 */
@Dependent
@Default
public class MyPojoImp implements MyPojo{

    public String getMessage() {
        return "Hello CDI 2.0 from MyPojoImp";
    }
}
