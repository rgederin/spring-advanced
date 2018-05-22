package com.gederin.beanpostprocessors.afterinit;

import com.gederin.beanpostprocessors.beforeinit.InjectRandomInt;

import org.springframework.stereotype.Service;


@Service
@EnableProfiling
public class ProfilingRandomPrintService implements ProfilingPrintService {

    @InjectRandomInt(min = 2, max = 10)
    private int randomTimes;

    public void print() {
        for (int i = 0; i < randomTimes; i++) {
            System.out.println("profiling random print service");
        }
    }
}
