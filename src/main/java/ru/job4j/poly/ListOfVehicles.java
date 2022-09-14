package ru.job4j.poly;

public class ListOfVehicles {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] array = {plane, train, bus};
        for (Vehicle v : array
        ) {
            System.out.println(v.getClass().getSimpleName());
            v.typeOfFuel();
            v.move();
            System.out.println();
        }
    }
}
