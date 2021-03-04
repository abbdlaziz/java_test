package com.aziz.javatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JavatestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavatestApplication.class, args);
    }

}
