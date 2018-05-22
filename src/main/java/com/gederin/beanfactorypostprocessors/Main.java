package com.gederin.beanfactorypostprocessors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);

        System.out.println(context.getBean(FibonacciComputer.class).computeFibonacciNumber(20));
    }
}
