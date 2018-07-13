/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author abdalla
 */
@Path("/test")
public class FirstRest {

    @Path("/path1")
    @GET
    public String testPath1() {
        return "Hello from path 1!";
    }

    @Path("/path2")
    @GET
    public String testPath2() {
        return "Hello from path 2!";
    }

}
