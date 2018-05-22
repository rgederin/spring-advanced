package com.gederin.beanpostprocessors.afterinit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AfterInitMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AfterInitMain.class, args);

        context.getBean(ProfilingPrintService.class).print();
    }
}
