/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author abdalla
 */
@Provider
public class ArithmeticExceptionMapper implements ExceptionMapper<ArithmeticException> {

    @Override
    public Response toResponse(ArithmeticException ex) {
        return Response.status(Status.BAD_REQUEST).
                entity(ex.getMessage()).
                type(MediaType.TEXT_PLAIN).
                build();
    }
}
