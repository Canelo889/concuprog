package GSnychronizedStatements;

// Déclaration de la classe TestingSynchronizedStatements
public class TestingSynchronizedStatements {
    // Méthode principale (main) du programme
    public static void main(String[] args) {
        // Création d'un objet Account partagé
        Account account = new Account();

        // Démarrage de deux threads simulés par des instances de la classe BankEmployee
        (new Thread(new BankEmployee("Mrs Fournier", account))).start();
        (new Thread(new BankEmployee("Mr Schmidhalter", account))).start();
    }
}
