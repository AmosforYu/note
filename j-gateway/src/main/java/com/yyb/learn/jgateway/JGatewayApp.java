package com.yyb.learn.jgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class JGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(JGatewayApp.class, args);
    }

}
