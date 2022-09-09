package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Petr Arsentev");
        student.setGroup(11);
        student.setDate(new Date());
        System.out.println(student.getFullName());
        System.out.println(student.getGroup());
        System.out.println(student.getDate());
    }
}
