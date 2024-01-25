package XPhaserBike;

import java.util.concurrent.Phaser;

// La classe TestingPhaserFamilyBikeTrip teste la synchronisation des étapes d'un voyage à vélo en famille.
public class TestingPhaserFamilyBikeTrip {

    public static void main(String[] args) {
        String[] family = {"Father", "Mother", "Son", "Daughter_1", "Daughter_2"};
        String[] routes = {"Sierre", "Sion", "Martigny", "St-Maurice", "Aigle", "Vevey"};

        Phaser phaser = new Phaser();
        phaser.register(); // Enregistre le thread principal auprès du phaser.
        int currentPhase = -1;

        // Crée et démarre un thread pour chaque membre de la famille.
        for (String member : family) {
            new FamilyMemberThread(phaser, member, routes.length);
        }

        System.out.println("La famille quitte Brig pour une balade à vélo jusqu'à Vevey.");

        // Parcours des différentes étapes du trajet.
        for (int i = 0; i < routes.length; i++) {
            currentPhase = phaser.getPhase(); // Obtient la phase actuelle du phaser.
            phaser.arriveAndAwaitAdvance(); // Attend que tous les threads atteignent cette étape avant de continuer.
            System.out.println("Tous les membres de la famille sont arrivés à " + routes[currentPhase]);
        }

        phaser.arriveAndDeregister(); // Désenregistre le thread principal.

        // Vérifie si le phaser est terminé.
        if (phaser.isTerminated()) {
            System.out.println("Fin de la balade à vélo en famille.");
        }
    }
}
