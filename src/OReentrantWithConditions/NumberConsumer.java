package OReentrantWithConditions;

// Déclaration de la classe NumberConsumer
public class NumberConsumer implements Runnable {
    // Instance de la classe LockedWithConditionsStack pour la consommation de nombres
    private LockedWithConditionsStack stack;

    // Constructeur prenant un objet LockedWithConditionsStack en tant que paramètre
    public NumberConsumer(LockedWithConditionsStack stack) {
        this.stack = stack;
    }

    // Méthode run() qui sera exécutée lorsque le thread est démarré
    @Override
    public void run() {
        // Boucle infinie pour continuer la consommation de nombres
        while (true) {
            // Affichage du nombre retiré de la pile
            System.out.println("Pop from stack: " + stack.popFromStack());
        }
    }
}
