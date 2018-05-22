package com.gederin.contextlistener;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ThreeConstructorMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ThreeConstructorMain .class, args);
    }
}
