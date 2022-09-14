package ru.job4j.poly;

public class Bus implements Transport {
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
}
