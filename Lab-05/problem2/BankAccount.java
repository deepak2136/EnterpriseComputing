package problem2;

import java.util.ArrayList;

public class BankAccount {

    private final long accno;
    private double balance;
    private static long next_accno = 10000;
    private final boolean debit = true;
    private final boolean credit = false;
    private ArrayList<Transaction> transactions;

    public BankAccount() {
        accno = next_accno++;
        balance = 0;
        transactions = new ArrayList<>();
    }

    public long getAccno() {
        return accno;
    }

    public BankAccount(double initialBalance) {
        accno = next_accno++;
        balance = initialBalance;
        transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        double newBalance = balance + amount;
        balance = newBalance;
        transactions.add(new Transaction("diposit ammount", amount, debit, balance));
    }

    public void withdraw(double amount) throws DailyLimitException, InsuffBalanceException {
        double newBalance = balance - amount;

        if (amount > 25000) {
            throw (new DailyLimitException());
        } else if (amount > balance) {
            throw (new InsuffBalanceException());
        }
        balance = newBalance;
        transactions.add(new Transaction("withdraw ammount", amount, credit, balance));
    }

    public double getBalance() {
        return balance;
    }
}

class InsuffBalanceException extends Exception {

    @Override
    public String toString() {
        return "Insufficient balance!!";
    }
}

class DailyLimitException extends Exception {

    @Override
    public String toString() {
        return "Ammount is larger than daily limit!";
    }
}
