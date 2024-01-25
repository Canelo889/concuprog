package RBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// La classe PostOffice représente un bureau de poste qui gère les colis
public class PostOffice {

    // La file d'attente des colis (utilisation d'une BlockingQueue pour la synchronisation)
    private BlockingQueue<Package> queue = new LinkedBlockingQueue<>();

    // Méthode pour enregistrer un colis au bureau de poste
    public void register(Package aPackage) {
        try {
            // Met le colis dans la file d'attente (si la file est pleine, elle attend)
            queue.put(aPackage);
        } catch (InterruptedException e) {
            // Gestion d'une éventuelle interruption de thread avec une RuntimeException
            throw new RuntimeException(e);
        }
    }

    // Méthode pour prendre un colis en vue de la livraison
    public void takeForDelivery() {
        try {
            // Prend le premier colis de la file d'attente (si la file est vide, elle attend)
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            // Gestion d'une éventuelle interruption de thread avec une RuntimeException
            throw new RuntimeException(e);
        }
    }
}
