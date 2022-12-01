package ru.job4j.map;

import java.util.ArrayList;
import java.util.Comparator;
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
        List<Label> labelList = new ArrayList<>();
        double sum = 0D;
        double average;
        for (int i = 0; i < pupils.get(0).subjects().size(); i++) {
            for (Pupil pupil : pupils) {
                sum += pupil.subjects().get(i).score();
            }
            average = sum / pupils.get(0).subjects().size();
            labelList.add(new Label(pupils.get(0).subjects().get(i).name(), average));
            sum = 0;
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
        List<Label> labelList = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < pupils.get(0).subjects().size(); i++) {
            for (Pupil pupil : pupils) {
                sum += pupil.subjects().get(i).score();
            }
            labelList.add(new Label(pupils.get(0).subjects().get(i).name(), sum));
            sum = 0;
        }
        labelList.sort(Comparator.naturalOrder());
        return labelList.get(labelList.size() - 1);
    }
}