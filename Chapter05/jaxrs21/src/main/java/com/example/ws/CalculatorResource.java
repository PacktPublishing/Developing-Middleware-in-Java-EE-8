/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author abdalla
 */
@Path("/calculator")
public class CalculatorResource {

    @Path("/divide")
    @GET
    public int divide(@QueryParam("x") int x,
            @QueryParam("y") int y) {
        return x / y;
    }
}
