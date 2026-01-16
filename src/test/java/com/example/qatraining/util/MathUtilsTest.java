package com.example.qatraining.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    // --- gcd: exemple clasice / edge cases (inclusiv negative, zero, coprime) ---
    @ParameterizedTest
    @CsvSource({
            "54, 24, 6",     // exemplu de bază
            "-54, 24, 6",    // negative -> modul
            "0, 5, 5",       // gcd(a,0) = |a|
            "7, 0, 7",
            "35, 64, 1",     // coprime
            "-81, -27, 27"   // ambele negative
    })
    void gcd_parametrized(int a, int b, int expected) {
        assertEquals(expected, MathUtils.gcd(a, b));
    }

    @Test
    void testul_meu(){
        int a = 54, b = 24 , expected = 6;
        assertEquals(expected,MathUtils.gcd(a,b));
    }


    // --- proprietăți: comutativitate gcd(a,b) = gcd(b,a) ---
    @Test
    void gcd_commutative_random() {
        Random r = new Random(1);
        for (int i = 0; i < 500; i++) {
            int a = r.nextInt(20001) - 10000; // [-10000, 10000]
            int b = r.nextInt(20001) - 10000;
            assertEquals(MathUtils.gcd(a, b), MathUtils.gcd(b, a));
        }
    }

    // --- proprietăți: gcd(a,0) = |a| și gcd(0,b) = |b| ---
    @Test
    void gcd_with_zero_property() {
        assertEquals(7, MathUtils.gcd(7, 0));
        assertEquals(7, MathUtils.gcd(0, 7));
        assertEquals(0, MathUtils.gcd(0, 0)); // convenție în implementarea noastră
        assertEquals(5, MathUtils.gcd(-5, 0));
    }

    // --- safeDivide: aruncă pe 0 ---
    @Test
    void safeDivide_throwsOnZero() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.safeDivide(1, 0));
    }

    // --- safeDivide: semne + trunchiere spre zero ---
    @ParameterizedTest
    @CsvSource({
            "7, 2, 3",      // 3.5 -> 3
            "-7, 2, -3",    // -3.5 -> -3 (spre zero)
            "7, -2, -3",
            "-7, -2, 3",
            "1, 1, 1",
            "0, 5, 0"
    })
    void safeDivide_works(int num, int den, int expected) {
        assertEquals(expected, MathUtils.safeDivide(num, den));
    }
}