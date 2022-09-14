package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void typeOfFuel() {
        System.out.println("Заправляется углем");
    }

    @Override
    public void move() {
        System.out.println("Ездит по рельсам");
    }
}
