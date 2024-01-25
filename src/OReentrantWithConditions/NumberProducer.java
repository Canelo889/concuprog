package OReentrantWithConditions;

// Déclaration de la classe NumberProducer
public class NumberProducer implements Runnable {
    // Instance de la classe LockedWithConditionsStack pour la production de nombres
    private LockedWithConditionsStack stack;

    // Constructeur prenant un objet LockedWithConditionsStack en tant que paramètre
    public NumberProducer(LockedWithConditionsStack stack) {
        this.stack = stack;
    }

    // Méthode run() qui sera exécutée lorsque le thread est démarré
    @Override
    public void run() {
        // Boucle for pour pousser des nombres sur la pile
        for (int i = 0; i < 100; i++) {
            // Affichage du nombre poussé sur la pile
            System.out.println("Push to stack " + i);
            // Appel de la méthode pushToStack() pour pousser le nombre sur la pile
            stack.pushToStack(i);
        }
    }
}
