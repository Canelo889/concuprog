package KGuardedBlocks;

// Déclaration de la classe Postman qui implémente l'interface Runnable
public class Postman implements Runnable {
    // Variable pour stocker une référence au bureau de poste
    private PostOffice postOffice;

    // Constructeur de la classe, prenant une référence au bureau de poste en tant que paramètre
    public Postman(PostOffice postOffice) {
        this.postOffice = postOffice;
    }

    // Implémentation de la méthode run() de l'interface Runnable
    @Override
    public void run() {
        // Boucle infinie représentant le comportement continu du facteur
        while (true) {
            // Le facteur prend des colis pour livraison en appelant la méthode takeForDelivery() du bureau de poste
            postOffice.takeForDelivery();
        }
    }
}
