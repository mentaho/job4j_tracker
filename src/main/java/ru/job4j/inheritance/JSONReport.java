package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        String ls = System.lineSeparator();
        return "{" + ls + "\t\"name\" : " + "\"" + name + "\"," + ls + "\t\"body\" : " + "\"" + body + "\"" + ls + "}";
    }
}
