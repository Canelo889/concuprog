package KGuardedBlocks;

import java.util.Random;

// Déclaration de la classe Customer qui implémente l'interface Runnable
public class Customer implements Runnable {
    // Variables pour stocker le nom du client et une référence au bureau de poste
    private String name;
    private PostOffice postOffice;

    // Constructeur de la classe, prenant le nom du client et une référence au bureau de poste en tant que paramètres
    public Customer(String name, PostOffice postOffice) {
        this.name = name;
        this.postOffice = postOffice;
    }

    // Méthode pour obtenir le nom du client
    public String getName() {
        return name;
    }

    // Implémentation de la méthode run() de l'interface Runnable
    @Override
    public void run() {
        // Création d'un objet Random pour générer des délais aléatoires entre les visites au bureau de poste
        Random random = new Random();

        // Boucle infinie représentant le comportement du client
        while(true) {
            try {
                // Pause aléatoire entre les visites au bureau de poste
                Thread.sleep(random.nextInt(1000));

                // Le client envoie un colis en s'enregistrant au bureau de poste
                postOffice.register(new Package(this));
            } catch (InterruptedException e) {
                // Capturer et relancer une RuntimeException si le thread est interrompu pendant la pause
                throw new RuntimeException(e);
            }
        }
    }
}
