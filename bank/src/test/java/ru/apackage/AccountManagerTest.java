package ru.apackage;

import org.junit.jupiter.api.Test;
import ru.apackage.exceptions.InvalidOperationException;

import static org.junit.jupiter.api.Assertions.*;

public class AccountManagerTest {

    @Test
    void createAccount_twice_throwsException() throws InvalidOperationException {
        AccountManager manager = new AccountManager();
        manager.createAccount(1);
        assertThrows(InvalidOperationException.class, () -> manager.createAccount(1));
    }

    @Test
    void getBalance_nonExistingAccount_throwsException() {
        AccountManager manager = new AccountManager();
        assertThrows(InvalidOperationException.class, () -> manager.getBalance(999));
    }

    @Test
    void deposit_toNonExistingAccount_throwsException() {
        AccountManager manager = new AccountManager();
        assertThrows(InvalidOperationException.class, () -> manager.deposit(1, 100));
    }

    @Test
    void withdraw_fromNonExistingAccount_throwsException() {
        AccountManager manager = new AccountManager();
        assertThrows(InvalidOperationException.class, () -> manager.withdraw(1, 50));
    }
}
