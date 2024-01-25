package ASimpleThread;

// Déclaration de la classe HelloRunnable, qui implémente l'interface Runnable
public class HelloRunnable implements Runnable {

    // Implémentation de la méthode run() de l'interface Runnable
    @Override
    public void run() {
        // Affichage du message "Hello from a Runnable object!" dans la console
        System.out.println('\t' + "Hello from a Runnable object!");
    }
}