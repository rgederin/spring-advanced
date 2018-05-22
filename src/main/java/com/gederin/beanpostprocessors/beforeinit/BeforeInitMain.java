package com.gederin.beanpostprocessors.beforeinit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeforeInitMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BeforeInitMain.class, args);

        context.getBean(InjectRandomPrintService.class).print();
    }
}
