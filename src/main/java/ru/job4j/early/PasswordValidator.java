package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("The password is empty");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("The length is incorrect");
        }
        for (char symbol: testSymbols(password)
             ) {
            if (Character.isDigit(symbol))
                throw new IllegalArgumentException("Need one digit");
            }
        return password;
    }



    private static char[] testSymbols(String passwordForTest) {
        return passwordForTest.toCharArray();
    }
}