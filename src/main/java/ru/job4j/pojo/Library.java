package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {

        Book clean = new Book("Clean code", 500);
        Book pinnokio = new Book("Pinnokio", 50);
        Book oldMan = new Book("Old Man", 200);
        Book honour = new Book("Honour", 700);
        Book[] books = new Book[4];
        books[0] = clean;
        books[1] = pinnokio;
        books[2] = oldMan;
        books[3] = honour;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPages());
        }
        Book temp;
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPages());
        }
        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println(books[index].getName() + " - " + books[index].getPages());
            }
        }
    }
}
