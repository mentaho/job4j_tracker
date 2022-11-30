package ru.job4j.map;

import java.util.List;

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
        return List.of();
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return List.of();
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}