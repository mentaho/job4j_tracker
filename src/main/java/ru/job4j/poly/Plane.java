package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void typeOfFuel() {
        System.out.println("Заправляет керосин");
    }

    @Override
    public void move() {
        System.out.println("Летает по воздуху");
    }
}
