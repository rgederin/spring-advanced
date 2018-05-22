package com.gederin.beanfactorypostprocessors;

public class LinnearFibonacciComputer implements FibonacciComputer {

    public long computeFibonacciNumber(int n) {
        System.out.println("compute fibonacci number with linnear alg");

        if (n <= 2) {
            return 1;
        }

        long preLast = 1;
        long last = 1;

        long answer = 0;

        for (int i = 2; i < n; i++) {
            answer = preLast + last;
            preLast = last;
            last = answer;
        }

        return answer;
    }
}