package KGuardedBlocks;

import java.util.LinkedList;
import java.util.Queue;

// Déclaration de la classe PostOffice
public class PostOffice {
    // Variable pour stocker la capacité maximale du bureau de poste
    private int capacity;

    // Constructeur de la classe, prenant la capacité maximale en tant que paramètre
    public PostOffice(int capacity) {
        this.capacity = capacity;
    }

    // Queue pour stocker les colis en attente d'envoi
    private Queue<Package> queueOfPackages = new LinkedList<Package>();

    // Méthode synchronized pour enregistrer un colis au bureau de poste
    public synchronized void register(Package aPackage) {
        // Attente active si la capacité maximale est atteinte
        while (queueOfPackages.size() >= capacity) {
            try {
                wait(); // Le thread attend jusqu'à ce qu'il y ait de l'espace disponible
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Ajout du colis à la file d'attente
        queueOfPackages.add(aPackage);

        // Notification à tous les threads en attente qu'un colis a été ajouté
        notifyAll();
    }

    // Méthode synchronized pour prendre un colis pour livraison
    public synchronized void takeForDelivery() {
        // Attente active si aucun colis n'est disponible
        while (queueOfPackages.size() <= 0) {
            try {
                wait(); // Le thread attend jusqu'à ce qu'il y ait un colis disponible
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Affichage du colis pris pour livraison
        System.out.println(queueOfPackages.remove());

        // Notification à tous les threads en attente qu'un colis a été pris pour livraison
        notifyAll();
    }
}
