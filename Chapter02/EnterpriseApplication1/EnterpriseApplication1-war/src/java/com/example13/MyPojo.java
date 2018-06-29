/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example13;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Dependent;

/**
 *
 * @author abdalla
 */
@Dependent
public class MyPojo {

    @PostConstruct
    public void init() {
        // write initialization code here
    }

    @PreDestroy
    public void destroy() {
        // write destruction code here
    }
}
