package DJoins;

import java.util.Stack;

// Déclaration de la classe EmptyingThread qui étend la classe Thread
public class EmptyingThread extends Thread {
    // Déclaration de deux piles (stack) d'entiers, sourceStack et targetStack
    private Stack<Integer> sourceStack;
    private Stack<Integer> targetStack;

    // Constructeur de la classe, prenant deux piles en tant que paramètres
    public EmptyingThread(Stack<Integer> sourceStack, Stack<Integer> targetStack) {
        this.sourceStack = sourceStack;
        this.targetStack = targetStack;
    }

    // Implémentation de la méthode run() de la classe Thread
    @Override
    public void run() {
        // Boucle tant que la pile source (sourceStack) n'est pas vide
        while (!sourceStack.isEmpty()) {
            // Affichage du message et manipulation des piles
            System.out.println("Number popped from source stack and pushed to target stack: "
                    + targetStack.push(sourceStack.pop()));
        }
    }
}

