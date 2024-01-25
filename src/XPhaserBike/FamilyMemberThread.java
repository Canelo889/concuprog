package XPhaserBike;

import java.util.Random;
import java.util.concurrent.Phaser;

// La classe FamilyMemberThread représente un membre de la famille participant à des étapes synchronisées.
public class FamilyMemberThread implements Runnable {

    private Phaser phaser;  // Phaser pour synchroniser les étapes entre les membres de la famille.
    private String name;    // Nom du membre de la famille.
    private int steps;       // Nombre d'étapes à effectuer.

    // Constructeur de la classe FamilyMemberThread.
    public FamilyMemberThread(Phaser phaser, String name, int steps) {
        this.phaser = phaser;
        this.name = name;
        this.steps = steps;

        phaser.register(); // Enregistre le thread auprès du phaser.
        new Thread(this).start(); // Démarre le thread.
    }

    // Méthode run() qui sera exécutée lorsque le thread est démarré.
    @Override
    public void run() {
        for (int i = 0; i < steps; i++) {
            System.out.println(name + ": Étape " + (i + 1) + " commencée");

            if (i == steps - 1) {
                phaser.arriveAndDeregister(); // Désenregistre le thread lors de la dernière étape.
            } else {
                phaser.arriveAndAwaitAdvance(); // Attend que tous les threads atteignent cette étape avant de continuer.
            }

            Random random = new Random();
            int time = random.nextInt(5) + 1; // Génère un temps d'attente aléatoire entre 1 et 5 secondes.
            try {
                Thread.sleep(time * 1000); // Convertit le temps en millisecondes et met en pause le thread.
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
