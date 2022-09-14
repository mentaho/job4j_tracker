package ru.job4j.poly;

public class Bus implements Transport, Vehicle {
    @Override
    public void go() {
        this.go();
    }

    @Override
    public void passengers(int quantity) {
        int passengers = quantity;
    }

    @Override
    public double fuel(int litres) {
        return 3.6 * litres;
    }

    @Override
    public void typeOfFuel() {
        System.out.println("Зправляется дизельным топливом");
    }

    @Override
    public void move() {
        System.out.println("Ездит по дороге");
    }
}
