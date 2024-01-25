package Pattern.Proxy.BankingApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFinance {
    public static void main(String[] args) {

        List<String> customersToExclude = new ArrayList<String>(Arrays.asList("Jean", "Pierre"));
        Bank proxyBank = new ProxyBank(customersToExclude);

        Account salaryAccount = new Account("Pascale", 16000);

        proxyBank.deposit("Marcel", salaryAccount, 1000);
        proxyBank.deposit("Jean", salaryAccount, 30000);
        proxyBank.withdraw("Marcel", salaryAccount, 1200);
        proxyBank.withdraw("Pascale", salaryAccount, 20000);
        proxyBank.withdraw("Pascale", salaryAccount, 1000);
        proxyBank.withdraw("Pierre", salaryAccount, 30000);
    }
}
