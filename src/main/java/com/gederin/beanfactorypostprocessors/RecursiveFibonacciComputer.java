package com.gederin.beanfactorypostprocessors;

import org.springframework.stereotype.Service;

@Service
@DeprecatedClass(newImplementation = LinnearFibonacciComputer.class)
public class RecursiveFibonacciComputer implements FibonacciComputer {

    public long computeFibonacciNumber(int n) {
        System.out.println("compute fibonacci number with recursive alg");

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return computeFibonacciNumber(n - 2) + computeFibonacciNumber(n - 1);
    }
}