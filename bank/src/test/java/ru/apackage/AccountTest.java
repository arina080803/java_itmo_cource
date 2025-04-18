package ru.apackage;

import org.junit.jupiter.api.Test;
import ru.apackage.exceptions.InvalidOperationException;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void deposit_negativeAmount_throwsException() {
        Account acc = new Account(1);
        assertThrows(InvalidOperationException.class, () -> acc.deposit(-100));
    }

    @Test
    void withdraw_moreThanBalance_throwsException() {
        Account acc = new Account(1);
        assertThrows(InvalidOperationException.class, () -> acc.withdraw(50));
    }

    @Test
    void withdraw_negativeAmount_throwsException() {
        Account acc = new Account(1);
        assertThrows(InvalidOperationException.class, () -> acc.withdraw(-10));
    }
}
