package ru.job4j.tracker;

public class TerminateAction implements UserAction {

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("The program has been terminated.");
        return false;
    }
}
