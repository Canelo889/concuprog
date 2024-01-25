package Pattern.Proxy.BankingApp;

public class RealBank implements Bank {

    @Override
    public void withdraw(String client, Account account, int amount) {
        account.withdraw(amount);
        System.out.println(client + " has withdrawn " + amount + " from " + account.toString() + ". New balance is " + account.getBalance());
    }

    @Override
    public void deposit(String client, Account account, int amount) {
        account.deposit(amount);
        System.out.println(client + " has deposited " + amount + " on " + account.toString() + ". New balance is " + account.getBalance());
    }
}
