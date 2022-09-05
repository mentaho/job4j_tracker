package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printMessage() {
        System.out.println("Condition is " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 12, "the error message");
        Error error3 = new Error(false, 7, "nothing");
        Error error4 = new Error(false, 0, "ОК");
        error1.printMessage();
        error2.printMessage();
        error3.printMessage();
        error4.printMessage();
    }
}
