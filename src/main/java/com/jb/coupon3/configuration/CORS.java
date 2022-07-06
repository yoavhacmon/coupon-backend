package com.jb.coupon3.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

//todo: add java.docs
@Configuration
public class CORS {
    @Bean
    public CorsFilter corsFilter(){
        //create new url configuration for browsers
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //create new cors configuration....
        CorsConfiguration config = new CorsConfiguration();
        //allow to get credentials in cors
        config.setAllowCredentials(true);
        //allow to get from any ip/domain
        config.addAllowedOriginPattern("*");
        //allow to get any header
        config.addAllowedHeader("*");
        //alow to get methods
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");

        config.setExposedHeaders(List.of("authorization"));
        //allow to get any route -> localhost:8080/api/lecturer -> /api/lecture is route
        source.registerCorsConfiguration("/**",config);
        ///return new configuration
        return new CorsFilter(source);
    }
}
