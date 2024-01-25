package EThreadInterferance;

// Déclaration de la classe Account
public class Account {
    // Variable privée pour stocker le solde du compte
    private int balance;

    // Méthode pour effectuer un dépôt sur le compte
    public void deposit(int money) {
        // Ajouter le montant donné (money) au solde du compte
        balance += money;
    }

    // Méthode pour effectuer un retrait du compte
    public void withdraw(int money) {
        // Soustraire le montant donné (money) du solde du compte
        balance -= money;
    }

    // Redéfinition de la méthode toString pour obtenir une représentation sous forme de chaîne de caractères de l'objet Account
    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}

