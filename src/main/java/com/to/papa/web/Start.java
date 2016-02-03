package com.to.papa.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Start {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Start.class, args);
    }
}
