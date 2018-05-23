package com.gederin.scopes;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopesMain {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((Config.class));

        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(500);
        }
    }
}
