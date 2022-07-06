package com.jb.coupon3.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;
/**
 * @author Yoav Hacmon, Guy Endvelt, Niv Pablo and Gery Glazer
 * 05.2022
 */

@Configuration
/**
 * this class is the configuration of the RestTemplate class
 * RestTemplate is used for the execution of HTTP requests on the client side
 */
public class MyRestTemplate {
    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder){
        return builder.setConnectTimeout(Duration.ofSeconds(10))
                .setReadTimeout(Duration.ofSeconds(10))
                .build();
    }
}
