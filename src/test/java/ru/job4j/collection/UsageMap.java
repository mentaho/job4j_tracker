package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("privet@yandex.ru", "Иванов Иван Иванович");
        map.put("hi@yandex.ru", "Петров Петр Петрович");
        map.put("salut@yandex.ru", "Федотов Федот Федотович");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
