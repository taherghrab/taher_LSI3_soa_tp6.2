package org.example;

import org.example.Web.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;

public class myconfig {

    @Bean
    public ResourceConfig resourceConfig(){

        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRSAPI.class);
        return jerseyServlet;

    }
}
