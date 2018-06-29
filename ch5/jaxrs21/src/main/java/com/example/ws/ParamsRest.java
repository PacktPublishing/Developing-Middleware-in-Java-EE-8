/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ws;

import java.util.List;
import java.util.Map;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author abdalla
 */
@Path("/params")
public class ParamsRest {

//    @GET
//    @Path("/{name}")
//    public String welcome(@PathParam("name") String username) {
//        return "Welcome " + username + "!";
//    }
//    @GET
//    public String welcome(@QueryParam("name")
//                          @DefaultValue("John")String username) {
//        return "Welcome " + username + "!";
//    }
//    @GET
//    @Path("/divide")
//    public int divide(@QueryParam("x") int x,
//            @QueryParam("y") int y) {
//        return x / y;
//    }
//    @GET
//    public String detectBrowser(@HeaderParam("Authorization") String authorization) {
//        return "Authorization header value is " + authorization;
//    }
//    @Path("/{path}")
//    @GET
//    public String testBeanParams(@BeanParam MyBeanParam myBeanParam){
//        return 
//                "Path Parameter: " + myBeanParam.getPathParam() + "\n" +
//                "Query Parameter: " + myBeanParam.getQueryParam()+ "\n" +
//                "Header Parameter: " + myBeanParam.getHeaderParam()+ "\n";
//    }
//    @Path("/{path}")
//    @GET
//    public void testContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
//
//        MultivaluedMap<String, String> pathParams = uriInfo.getPathParameters();
//        MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters();
//        MultivaluedMap<String, String> requestHeaders = httpHeaders.getRequestHeaders();
//        Map<String, Cookie> cookies = httpHeaders.getCookies();
//
//        // process path parameters
//        for (String pathParam : pathParams.keySet()) {
//            // get the value of the path parameter
//            String value = pathParams.getFirst(pathParam);
//        }
//
//        // process query parameters
//        for (String queryParameter : queryParameters.keySet()) {
//            // get the value of the query parameter
//            String value = queryParameters.getFirst(queryParameter);
//
//            // get the all the values of the query parameter with this name
//            List<String> values = queryParameters.get(queryParameter);
//        }
//
//        // process header parameters
//        for (String requestHeader : requestHeaders.keySet()) {
//            // get the value of the header parameter
//            String value = requestHeaders.getFirst(requestHeader);
//
//            // get the all the values of the header parameter with this name
//            List<String> values = queryParameters.get(requestHeader);
//        }
//
//        // process cookie parameters
//        for (String cookieName : cookies.keySet()) {
//            Cookie cookie = cookies.get(cookieName);
//            
//        }
//
//    }
    @POST
    public String testForm(@FormParam("name") String username) {
        return "Welcome " + username + "!";
    }

}
