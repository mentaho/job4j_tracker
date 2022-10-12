package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {

        String[] commonPasswords = new String[]{"qwerty", "password", "admin", "user", "12345"};

        if (password == null) {
            throw new IllegalArgumentException("The password is empty");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("The length is incorrect");
        }
        if (!testDigitalSymbols(password)) {
            throw new IllegalArgumentException("Need one digital");
        }
        if (!testUpperCase(password)) {
            throw new IllegalArgumentException("Need one UpperCase");
        }
        if (!testLowerCase(password)) {
            throw new IllegalArgumentException("Need one LowerCase");
        }
        if (!testSpecialSymbol(password)) {
            throw new IllegalArgumentException("Need one special symbol");
        }
        if (testCommonPasswords(commonPasswords, password)) {
            throw new IllegalArgumentException("Use non common phrases");
        }

        return password;
    }

    private static boolean testDigitalSymbols(String passwordForTest) {
        for (char symbol : passwordForTest.toCharArray()) {
            if (Character.isDigit(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean testUpperCase(String passwordForTest) {
        for (char symbol : passwordForTest.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean testLowerCase(String passwordForTest) {
        for (char symbol : passwordForTest.toCharArray()) {
            if (Character.isLowerCase(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean testSpecialSymbol(String passwordForTest) {
        for (char symbol : passwordForTest.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && !Character.isWhitespace(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean testCommonPasswords(String[] array, String passwordForTest) {
        for (String commonPassword : array) {
            if (passwordForTest.toLowerCase().contains(commonPassword)) {
                return true;
            }
        }
        return false;
    }
}