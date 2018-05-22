package com.gederin.contextlistener;

import com.gederin.beanpostprocessors.beforeinit.InjectRandomInt;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class ThreeConstructorService  {

    @InjectRandomInt(min = 2, max = 10)
    private int randomTimes;

    public ThreeConstructorService(){
        System.out.println("phase 1 - constructor. Random times = " + randomTimes);
    }

    @PostConstruct
    public void init(){
        System.out.println("phase 2 - @postConstruct. Random times = " + randomTimes);
    }

    @PostProxy
    public void contextListener() {
        System.out.println("phase 3 - context listener. Random times = " + randomTimes);
    }
}
