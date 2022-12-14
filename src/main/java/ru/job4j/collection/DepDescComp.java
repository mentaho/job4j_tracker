package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String firstStringO1 = o1.contains("/") ? o1.substring(0, o1.indexOf("/")) : o1;
        String secondStringO1 = o1.contains("/") ? o1.substring(o1.indexOf("/")) : "";
        String firstStringO2 = o2.contains("/") ? o2.substring(0, o2.indexOf("/")) : o2;
        String secondStringO2 = o2.contains("/") ? o2.substring(o2.indexOf("/")) : "";
        Comparator<String> finalComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return firstStringO2.compareTo(firstStringO1);
            }
        }.thenComparing(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return secondStringO1.compareTo(secondStringO2);
            }
        });
        return finalComparator.compare(o1, o2);
    }
}