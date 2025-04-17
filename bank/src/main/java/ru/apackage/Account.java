package ru.apackage;

import java.util.ArrayList;
import java.util.List;

import ru.apackage.exceptions.InvalidOperationException;

/**
 * Класс банковского счёта.
 */
public class Account {
    private final int acc_id;
    private double balance;
    private final List<String> acc_history;

    public Account(int acc_id) {
        this.acc_id = acc_id;
        this.balance = 0.0;
        this.acc_history = new ArrayList<>();
    }

    public void deposit(double amount) throws InvalidOperationException {
        if (amount <= 0) throw new InvalidOperationException("Amount must be positive");
        balance += amount;
        acc_history.add("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InvalidOperationException {
        if (amount > balance) throw new InvalidOperationException("Insufficient funds");
        if (amount <= 0) throw new InvalidOperationException("Amount must be positive");
        balance -= amount;
        acc_history.add("Withdrawn: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getHistory() {
        return new ArrayList<>(acc_history);
    }

    public int getId() {
        return acc_id;
    }
}
