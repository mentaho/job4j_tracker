package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.map(Pupil::subjects)
                .flatMap(List::stream)
                .map(Subject::score)
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.name(), pupil
                        .subjects()
                        .stream()
                        .map(Subject::score)
                        .mapToInt(Integer::valueOf)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(Pupil::subjects)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Subject::name,
                                               LinkedHashMap::new,
                                               Collectors.averagingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.name(), pupil
                        .subjects()
                        .stream()
                        .map(Subject::score)
                        .mapToInt(Integer::valueOf)
                        .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(new Tuple(null, 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.map(Pupil::subjects)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Subject::name,
                                               LinkedHashMap::new,
                                               Collectors.summingDouble(Subject::score)))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparing(Tuple::score))
                .orElse(new Tuple(null, 0));

    }
}