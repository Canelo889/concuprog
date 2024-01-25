package CInterruption;

// Déclaration de la classe TestingInterruptedSleepThread
public class TestingInterruptedSleepThread {

    // Méthode principale (main) du programme
    public static void main(String[] args) throws InterruptedException {
        // Affichage du message "Testing interruptions" dans la console
        System.out.println("Testing interruptions");

        // Création d'un nouveau thread à partir d'une instance de InterruptedSleepThread et démarrage du thread
        Thread thread = new Thread(new InterruptedSleepThread());
        thread.start();

        // Affichage du message "Sleeping" dans la console et pause du thread principal pendant 3000 millisecondes (3 secondes)
        System.out.println("Sleeping ");
        Thread.sleep(3000);

        // Affichage du message "Interrupting the second thread" dans la console
        System.out.println("Interrupting the second thread");

        // Interruption du thread créé précédemment
        thread.interrupt();
    }
}
