package Pattern.Proxy.BankingApp;

public interface Bank {
    public void withdraw(String client, Account account, int money);
    public void deposit(String client, Account account, int money);
}
