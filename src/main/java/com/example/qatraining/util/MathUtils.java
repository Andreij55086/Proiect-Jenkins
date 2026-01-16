package com.example.qatraining.util;

public class MathUtils {

    /**
     * Returns the greatest common divisor using Euclid's algorithm.
     * Edge cases:
     * - if either argument is 0, returns absolute value of the other
     * - works with negative numbers
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    /**
     * Safely divides two integers and rounds toward zero.
     * Throws IllegalArgumentException if divisor is zero.
     */
    public static int safeDivide(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("denominator must not be zero");
        return numerator / denominator;
    }
}
