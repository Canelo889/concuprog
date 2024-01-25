package Pattern.Proxy.BankingApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProxyBank implements Bank {

    private Bank bank = new RealBank();

    private List<String> blackListOfClients;

    public ProxyBank(List<String> blackListOfClients) {
        this.blackListOfClients = blackListOfClients;
    }

    @Override
    public void withdraw(String client, Account account, int money) {
        try {
            if (blackListOfClients.contains(client)) {
                throw new Exception(client + " is on a blacklist and has not the right to WITHDRAW money from " + account.toString());
            } else if (!account.getOwner().equals(client))  {
                throw new Exception(client + " cannot WITHDRAW money from " + account.toString() + " because not proprietary of it.");
            } else if (account.getBalance() < money) {
                throw new Exception(client + " cannot WITHDRAW money from " + account.toString() + " because there is not enough money on the account.");
            }
            bank.withdraw(client, account, money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deposit(String client, Account account, int money) {
        try {
            if (blackListOfClients.contains(client)) {
                throw new Exception(client + " is on a blacklist and has not the right to DEPOSIT money into " + account.toString());
            }
            bank.deposit(client, account, money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
