package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        String ls = System.lineSeparator();
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже" + ls
                               + "Пешеходы по лужам," + ls
                               + "А вода по асфальту рекой." + ls
                               + "И неясно прохожим" + ls
                               + "В этот день непогожий," + ls
                               + "Почему я веселый такой.");
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят," + ls
                               + "Одеяла и подушки ждут ребят." + ls
                               + "Даже сказка спать ложится," + ls
                               + "Чтобы ночью нам присниться." + ls
                               + "Ты ей пожелай: «Баю-бай!»");

        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        jukebox.music(1);
        jukebox.music(2);
        jukebox.music(-1);
    }
}