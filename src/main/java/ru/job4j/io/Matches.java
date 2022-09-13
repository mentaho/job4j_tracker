package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches;
                matches = Integer.parseInt(input.nextLine());
                if (matches > 3 || matches > count) {
                    System.out.println("Можно взять не более 3 спичек и не более оставшегося количества");
                    System.out.println("Внимание! Осталось " + count + " спичек.");
                } else {
                    turn = !turn;
                    count -= matches;
                    System.out.println("Внимание! Осталось " + count + " спичек.");
                }
            }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}