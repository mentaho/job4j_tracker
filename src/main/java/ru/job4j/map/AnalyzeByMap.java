package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int quantityOfClasses = 0;
        double sumOfMarks = 0.0D;
        for (Pupil pupil : pupils) {
            quantityOfClasses += pupil.subjects().size();
            List<Subject> subjectList = pupil.subjects();
            for (Subject subject : subjectList) {
                sumOfMarks += subject.score();
            }
        }
        return (sumOfMarks / quantityOfClasses);
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double averageScore = 0D;
            int size = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                averageScore += subject.score();
            }
            averageScore = averageScore / size;
            labelList.add(new Label(pupil.name(), averageScore));
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labelList = new ArrayList<>();
        Integer sum;
        for (Pupil pupil : pupils) {
            for (Subject subjects : pupil.subjects()) {
                map.merge(subjects.name(), subjects.score(), (oldValue, newValue) -> oldValue + subjects.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labelList.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }

        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            labelList.add(new Label(pupil.name(), score));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labelList = new ArrayList<>();
        Integer sum;
        for (Pupil pupil : pupils) {
            for (Subject subjects : pupil.subjects()) {
                map.merge(subjects.name(), subjects.score(), (oldValue, newValue) -> oldValue + subjects.score());
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            labelList.add(new Label(entry.getKey(), entry.getValue()));
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}