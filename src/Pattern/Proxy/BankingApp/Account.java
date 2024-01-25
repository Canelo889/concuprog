package Pattern.Proxy.BankingApp;

import java.util.Random;

public class Account {

    private int balance;
    private int accountNumber;
    private String owner;

    public Account(String owner, int startBalance) {
        this.owner = owner;
        this.balance = startBalance;
        this.accountNumber = new Random().hashCode();
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "account " + this.accountNumber + " belonging to " + this.owner;
    }
}
