package Utility;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {
    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
    private static final String DIGIT = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/";

    private static Random random = new SecureRandom();

    public static String generatePassword(int length, boolean useUpperCase, boolean useDigit, boolean useSpecialChars) {
        StringBuilder password = new StringBuilder(length);
        String charSet = CHAR_LOWERCASE;

        if (useUpperCase) {
            charSet += CHAR_UPPERCASE;
        }

        if (useDigit) {
            charSet += DIGIT;
        }

        if (useSpecialChars) {
            charSet += SPECIAL_CHARS;
        }

        for (int i = 0; i < length; i++) {
            password.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        String password = generatePassword(12, true, true, true);
        System.out.println("Generated Password: " + password);
    }
}