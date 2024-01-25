package DJoins;

import java.util.Stack;

// Déclaration de la classe FillingThread qui étend la classe Thread
public class FillingThread extends Thread {
    // Déclaration de deux piles (stack) d'entiers, sourceStack et targetStack
    private Stack<Integer> sourceStack;
    private Stack<Integer> targetStack;

    // Référence vers l'autre thread (EmptyingThread) qui est en train de vider la pile targetStack
    private Thread otherThread;

    // Constructeur de la classe, prenant deux piles et un autre thread en tant que paramètres
    public FillingThread(Stack<Integer> sourceStack, Stack<Integer> targetStack, Thread otherThread) {
        this.sourceStack = sourceStack;
        this.targetStack = targetStack;
        this.otherThread = otherThread;
    }

    // Implémentation de la méthode run() de la classe Thread
    @Override
    public void run() {
        try {
            // Attendre que l'autre thread (EmptyingThread) ait terminé son travail
            otherThread.join();

            // Affichage du message indiquant le début du remplissage
            System.out.println("--- Starting Filling back ---");

            // Boucle tant que la pile cible (targetStack) n'est pas vide
            while (!targetStack.isEmpty()) {
                // Affichage du message et manipulation des piles
                System.out.println("From target stack to source stack " + sourceStack.push(targetStack.pop()));
            }
        } catch (InterruptedException e) {
            // Capturer et relancer une RuntimeException si le thread est interrompu pendant l'attente
            throw new RuntimeException(e);
        }
    }
}
