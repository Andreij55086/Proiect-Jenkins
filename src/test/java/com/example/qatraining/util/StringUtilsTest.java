package com.example.qatraining.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void normalizeUsername_trimsAndLowercases() {
        assertEquals("john doe", StringUtils.normalizeUsername("  John   Doe  "));
    }

    // TODO: test null input -> empty string
    // TODO: test multiple spaces collapse
    // TODO: test locale-insensitive lowercasing (e.g., Turkish i)
    @Test
    void isLoosePalindrome_works() {
        assertTrue(StringUtils.isLoosePalindrome("A man, a plan, a canal: Panama!"));
        assertFalse(StringUtils.isLoosePalindrome("Hello"));
    }
}
