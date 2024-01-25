package DJoins;


// Importation de la classe Stack depuis le package java.util
import java.util.Stack;

// Déclaration de la classe TestingJoins
public class TestingJoins {
    // Méthode principale (main) du programme
    public static void main(String[] args) {
        // Création de deux piles d'entiers, sourceStack et targetStack
        Stack<Integer> sourceStack = new Stack<Integer>();
        Stack<Integer> targetStack = new Stack<Integer>();

        // Remplissage de la première pile (sourceStack)
        for (int i = 1; i <= 10; i++) {
            sourceStack.push(i);
        }

        // Création d'un thread de vidage (EmptyingThread) avec les piles sourceStack et targetStack
        Thread emptyingThread = new EmptyingThread(sourceStack, targetStack);

        // Création d'un thread de remplissage (FillingThread) avec les piles sourceStack, targetStack, et le thread de vidage
        Thread fillingThread = new FillingThread(sourceStack, targetStack, emptyingThread);

        // Démarrage des threads
        emptyingThread.start();
        fillingThread.start();
    }
}
