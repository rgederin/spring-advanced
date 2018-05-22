package com.gederin.beanpostprocessors.beforeinit;

import org.springframework.stereotype.Service;

@Service
public class InjectRandomPrintService {

    @InjectRandomInt(min = 2, max = 10)
    private int randomTimes;

    public void print() {
        for (int i = 0; i < randomTimes; i++) {
            System.out.println("inject random print service");
        }
    }
}
