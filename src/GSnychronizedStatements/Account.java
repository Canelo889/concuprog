package GSnychronizedStatements;

// Déclaration de la classe Account
public class Account {
    // Variable privée pour stocker le solde du compte
    private int balance;

    // Deux objets de verrouillage pour synchroniser les opérations de dépôt et de retrait
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    // Méthode pour effectuer un dépôt sur le compte de manière thread-safe
    public void deposit(int money) {
        // Utilisation du verrou lock1 pour synchroniser l'opération
        synchronized(lock1) {
            balance += money;
        }
    }

    // Méthode pour effectuer un retrait du compte de manière thread-safe
    public void withdraw(int money) {
        // Utilisation du verrou lock2 pour synchroniser l'opération
        synchronized(lock2) {
            balance -= money;
        }
    }

    // Redéfinition de la méthode toString pour obtenir une représentation sous forme de chaîne de caractères de l'objet Account
    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
