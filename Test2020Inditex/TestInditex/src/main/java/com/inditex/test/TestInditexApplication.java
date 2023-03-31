package com.inditex.test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"com.inditex.test.infraestructura.config"})
public class TestInditexApplication {
    public static void main(final String[] args) {
        SpringApplication.run(TestInditexApplication.class, args);
        }
    }
