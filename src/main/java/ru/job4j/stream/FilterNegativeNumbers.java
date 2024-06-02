package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 7, -4, 0, 8, 256);
        List<Integer> positive = numbers.stream()
                .filter(number -> number > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}