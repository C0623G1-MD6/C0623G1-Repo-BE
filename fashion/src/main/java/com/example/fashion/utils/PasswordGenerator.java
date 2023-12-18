package com.example.fashion.utils;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PasswordGenerator {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    private static final String ALL_CHARS = LOWER + UPPER + DIGITS;
    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomPassword(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be positive");
        }

        List<Character> chars = new ArrayList<>();
        // Ensure at least one character of each type is used
        chars.add(LOWER.charAt(random.nextInt(LOWER.length())));
        chars.add(UPPER.charAt(random.nextInt(UPPER.length())));
        chars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));

        // Fill the remaining length with random chars
        for (int i = chars.size(); i < length; i++) {
            chars.add(ALL_CHARS.charAt(random.nextInt(ALL_CHARS.length())));
        }

        // Shuffle the characters for good measure
        Collections.shuffle(chars);

        // Build the final password string
        StringBuilder password = new StringBuilder();
        for (char ch : chars) {
            password.append(ch);
        }

        return password.toString();
    }
}
