package com.cy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer3344_APP {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer3344_APP.class,args);
    }
}
