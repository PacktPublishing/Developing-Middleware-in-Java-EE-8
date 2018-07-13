/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example4;

import javax.enterprise.context.Dependent;
import javax.interceptor.Interceptors;

/**
 *
 * @author abdalla
 */
@Dependent
public class MyPojo {

    @Interceptors(MyInterceptor.class)
    public String getMessage() {
        return "test method";
    }
}
