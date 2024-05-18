package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает поведение банковского счета
 * @author Aleksey Bubnov
 * @version 1.0
 */
public class Account {
    /**
     * Реквизит счета
     */
    private String requisite;
    /**
     * Баланс счета
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение equals для сравнения счета по реквизитам
     * @param o сравниваемый объект
     * @return возвращает true при равных реквизитах счета
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
