/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example2;

import javax.enterprise.context.RequestScoped;

/**
 *
 * @author abdalla
 */
@RequestScoped
public class MyPojoImp implements MyPojo{

    @Override
    public String getMessage() {
        return "Hello CDI 2.0 from MyPojoImp";
    }
}
