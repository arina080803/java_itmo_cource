package ru.apackage;

import ru.apackage.exceptions.InvalidOperationException;
import ru.apackage.exceptions.InsufficientFundsException;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс-менеджер, управляющий множеством банковских счетов.
 */
public class AccountManager {
    private final Map<Integer, Account> accounts = new HashMap<>();

    public void createAccount(int acc_id) throws InvalidOperationException {
        if (accounts.containsKey(acc_id)) {
            throw new InvalidOperationException("Account with ID " + acc_id + " already exists");
        }
        accounts.put(acc_id, new Account(acc_id));
    }

    public double getBalance(int acc_id) throws InvalidOperationException {
        return getAccount(acc_id).getBalance();
    }

    public void deposit(int acc_id, double amount) throws InvalidOperationException {
        getAccount(acc_id).deposit(amount);
    }

    public void withdraw(int acc_id, double amount) throws InvalidOperationException, InsufficientFundsException {
        getAccount(acc_id).withdraw(amount);
    }

    public Account getAccount(int acc_id) throws InvalidOperationException {
        Account acc = accounts.get(acc_id);
        if (acc == null) throw new InvalidOperationException("Account not found: " + acc_id);
        return acc;
    }

    public void printHistory(int acc_id) throws InvalidOperationException {
        Account acc = getAccount(acc_id);
        for (String entry : acc.getHistory()) {
            System.out.println(entry);
        }
    }
}
