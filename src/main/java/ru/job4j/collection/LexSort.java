package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftChar = left.split(". ");
        String[] rightChar = right.split(". ");
        Integer leftEnumeration = Integer.parseInt(leftChar[0]);
        Integer rightEnumeration = Integer.parseInt(rightChar[0]);
        return leftEnumeration.compareTo(rightEnumeration);
    }
}