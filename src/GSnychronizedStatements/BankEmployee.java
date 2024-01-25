package GSnychronizedStatements;

// Déclaration de la classe BankEmployee qui implémente l'interface Runnable
public class BankEmployee implements Runnable {
    // Variables privées pour stocker le nom de l'employé et une référence vers le compte associé
    private String name;
    private Account account;

    // Constructeur de la classe, prenant le nom de l'employé et une référence vers le compte en tant que paramètres
    public BankEmployee(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    // Implémentation de la méthode run() de l'interface Runnable
    @Override
    public void run() {
        // Boucle infinie représentant les opérations de l'employé sur le compte
        while (true) {
            // Dépôt d'un montant aléatoire entre 0 et 999 sur le compte
            account.deposit((int)(Math.random()*(1000)));

            // Affichage du nom de l'employé, de l'opération de dépôt et du solde actuel du compte
            System.out.println("Bank employee " + name + " deposited money on the account, resulting in " + account);

            // Retrait d'un montant aléatoire entre 0 et 999 du compte
            account.withdraw((int)(Math.random()*(1000)));

            // Affichage du nom de l'employé, de l'opération de retrait et du solde actuel du compte
            System.out.println("Bank employee " + name + " withdraw money from the account, resulting in " + account);

            // Pause de 100 millisecondes entre chaque itération de la boucle
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Capturer et relancer une RuntimeException si le thread est interrompu pendant la pause
                throw new RuntimeException(e);
            }
        }
    }
}
