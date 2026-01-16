package com.example.qatraining.util;

import java.util.Locale;

public class StringUtils {

    /**
     * Normalizes a username:
     * - trims whitespace
     * - collapses internal multiple spaces to a single space
     * - lowercases using ROOT locale
     * Returns empty string if input is null.
     */
    public static String normalizeUsername(String input) {
        if (input == null) return "";
        String trimmed = input.trim();
        String collapsed = trimmed.replaceAll("\s+", " ");
        return collapsed.toLowerCase(Locale.ROOT);
    }

    /**
     * Checks if a string is a palindrome ignoring non-alphanumeric chars and case.
     */
    public static boolean isLoosePalindrome(String s) {
        if (s == null) return false;
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
        int i = 0, j = cleaned.length() - 1;
        while (i < j) {
            if (cleaned.charAt(i++) != cleaned.charAt(j--)) return false;
        }
        return true;
    }
}
