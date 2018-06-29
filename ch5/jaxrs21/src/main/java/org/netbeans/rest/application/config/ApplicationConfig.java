/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import com.example.ws.ArithmeticExceptionMapper;
import com.example.ws.CalculatorResource;
import com.example.ws.ImagesResource;
import com.example.ws.FirstRest;
import com.example.ws.MoviesResource;
import com.example.ws.ParamsRest;
import com.example.ws.SseResource;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

/**
 *
 * @author abdalla
 */
@ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
//        resources.add(MyObjectMapperProvider.class);
//        resources.add(JacksonFeature.class);
        resources.add(ParamsRest.class);
        resources.add(FirstRest.class);
        resources.add(MoviesResource.class);
        resources.add(ImagesResource.class);
        resources.add(CalculatorResource.class);
        resources.add(ArithmeticExceptionMapper.class);
        resources.add(SseResource.class);
        resources.add(MultiPartFeature.class);
        return resources;
    }

}
