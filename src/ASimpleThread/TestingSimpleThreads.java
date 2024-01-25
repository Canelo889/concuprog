package ASimpleThread;

// Déclaration de la classe TestingSimpleThreads
public class TestingSimpleThreads {

    // Méthode principale (main) du programme
    public static void main(String[] args) {
        // Affichage du message "Hello world from the main thread !" dans la console
        System.out.println("Hello world from the main thread !");

        // Création d'un nouvel objet Runnable (HelloRunnable) encapsulé dans un Thread et démarrage du thread
        new Thread(new HelloRunnable()).start();

        // Création d'un nouvel objet HelloThread et démarrage du thread
        new HelloThread().start();
    }
}