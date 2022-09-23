package ru.job4j.tracker;

public class TerminateAction implements UserAction {
    private final Output out;

    public TerminateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        //out.println("The program has been terminated.");
        return false;
    }
}
