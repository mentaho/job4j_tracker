package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperations(int a) {
        return sum(a) + minus(a) + divide(a) + multiply(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rsl = calculator.sumAllOperations(5);
        System.out.println(rsl);
    }
}