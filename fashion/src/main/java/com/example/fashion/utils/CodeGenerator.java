package com.example.fashion.utils;

import java.util.Random;

public class CodeGenerator {
    private static final String PREFIX = "PNK-";
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(PREFIX);

        for (int i = 0; i < 10 - PREFIX.length(); i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }
}