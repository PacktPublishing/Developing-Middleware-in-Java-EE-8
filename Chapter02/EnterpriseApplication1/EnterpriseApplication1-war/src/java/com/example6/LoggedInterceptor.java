/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example6;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author abdalla
 */
@Interceptor
@Logged
public class LoggedInterceptor {

    @AroundInvoke
    public Object interceptMethod(InvocationContext ctx) throws Exception {
        Object retValue = ctx.proceed();
        return "intercepted " + retValue;
    }
}
