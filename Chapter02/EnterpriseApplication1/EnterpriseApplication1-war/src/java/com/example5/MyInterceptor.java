/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example5;

import com.example4.*;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author abdalla
 */
public class MyInterceptor {

    @AroundInvoke
    public Object interceptMethod(InvocationContext ctx) throws Exception {
        Object retValue = ctx.proceed();
        return "intercepted " + retValue;
    }
}
