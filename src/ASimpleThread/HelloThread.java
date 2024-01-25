package ASimpleThread;

// Déclaration de la classe HelloThread, qui étend la classe Thread
public class HelloThread extends Thread {

    // Implémentation de la méthode run() de la classe Thread
    @Override
    public void run() {
        // Affichage du message "Hello from a class extending a Thread!" dans la console
        System.out.println('\t' + "Hello from a class extending a Thread!");
    }
}