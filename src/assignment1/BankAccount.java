package assignment1;

import java.util.*;

public class BankAccount {
    private final int accountNumber;
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;

        Random r = new Random( System.currentTimeMillis());
        this.accountNumber =  10000 + r.nextInt(20000);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
