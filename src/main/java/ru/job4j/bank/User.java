package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает поведение объекта User
 * @author Aleksey Bubnov
 * @version 1.0
 */
public class User {
    /**
     * Номер паспорта
     */
    private String passport;
    /**
     * Имя
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     *
     * @return возвращает паспорт
     */
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределяет equals что бы сравнивать User по номеру паспорта
     * @param o сравниваемый объект
     * @return возвращает true, если номера паспортов у пользователей совпали
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}