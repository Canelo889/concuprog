package EThreadInterferance;

public class Customer implements Runnable {
    private String name;
    private Account account;

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            account.deposit((int)(Math.random()*(1000)));
            System.out.println(name
                    + " deposited money on the account, resulting in "
                    + account);
            account.withdraw((int)(Math.random()*(1000)));
            System.out.println(name
                    + " withdraw money from the account, resulting in "
                    + account);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
