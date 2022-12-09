package ru.job4j.bank;

import java.util.*;

/**
 * Класс реализует действяи с банковским аккаунтом добавление пользователя, удаление пользователя,
 * добавление аккаунта и перевод средств между аккаунтами
 * @author Aleksey Bubnov
 * @version 1.0
 */
public class BankService {
    /**
     * Позователи хранятся в переменной Users
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет, если user не существует, то добавляет его в переменную.
     * @param user пользователь, которого надо добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод идентифицирует пользователя по номеру паспорта и при удаляет его из переменной
     * @param passport номер паспорта пользователя
     * @return возращает true при удачном удалении пользователя
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод проверяет пользователя по номеру паспорта и если такой пользователь сущестует,
     * добавляет к нему новый аккаунт
     * @param passport номер паспорта пользователя
     * @param account банковский аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод находит пользователя по номеру паспорта и возвращает экземпляр User
     * @param passport номер паспорта пользователя
     * @return возращаеет экземпляр User, если он существует или null если нет
     */
    public User findByPassport(String passport) {
        Set<User> setOfPassports = users.keySet();
        for (User user : setOfPassports) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод идентифицирует пользователя по паспорту и аккаунт по реквизиту, возращает аккаунт
     * @param passport номер паспорта прользователя
     * @param requisite реквизиты счета
     * @return если найдет пользователь и счет возвращает счет, в противном случае null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account account : accountList) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }

        }
        return null;
    }

    /**
     * Метод переводит средства с аккакунта одного пользователя на аккаунт другого или тго же пользователя
     * @param srcPassport номер паспорта пользователя, который переводит средства
     * @param srcRequisite реквизиты счета, откуда переводятся средства
     * @param destPassport намер паспорта пользваотеля, который принимает средства
     * @param destRequisite реквизиты счет, на который зачисляются средства
     * @param amount сумма перевода
     * @return возвращает true при удачном переводе и false при невозможности совершить перевод
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account sourceAccount = findByRequisite(srcPassport, srcRequisite);
        Account destinationAccount = findByRequisite(destPassport, destRequisite);
        if (sourceAccount != null && destinationAccount != null && amount <= sourceAccount.getBalance()) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Возвращает список аккаунтов
     * @param user пользователь, чей список аккаунтов возвращается
     * @return список акккаунтов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}