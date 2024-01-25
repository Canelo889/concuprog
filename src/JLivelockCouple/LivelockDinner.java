package JLivelockCouple;

// Déclaration de la classe LivelockDinner
public class LivelockDinner {

    public static void main(String[] args) {
        // Création des objets représentant le mari (husband), la femme (wife) et la cuillère (spoon)
        final Diner husband = new Diner("Bob");
        final Diner wife = new Diner("Alice");
        final Spoon spoon = new Spoon(husband);

        // Création et démarrage du premier thread représentant le mari
        new Thread(new Runnable() {
            public void run() {
                husband.eatWith(spoon, wife);
            }
        }).start();

        // Création et démarrage du deuxième thread représentant la femme
        new Thread(new Runnable() {
            public void run() {
                wife.eatWith(spoon, husband);
            }
        }).start();
    }
}
