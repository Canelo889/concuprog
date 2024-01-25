package BSleepMessages;

// Déclaration de la classe SleepMessages qui implémente l'interface Runnable
public class SleepMessages implements Runnable {

    // Déclaration d'un tableau de chaînes représentant les paroles d'une chanson
    public String[] song =
            {"Georges Brassens (1964) - Les Copains d'abord",
                    "Non, ce n'était pas le radeau",
                    "De la Méduse, ce bateau",
                    "Qu'on se le dise au fond des ports",
                    "Dise au fond des ports",
                    "Il naviguait en père peinard",
                    "Sur la grand-mare des canards",
                    "Et s'appelait les Copains d'abord",
                    "Les Copains d'abord"};

    // Implémentation de la méthode run() de l'interface Runnable
    @Override
    public void run() {
        // Parcourir chaque ligne (phrase) de la chanson
        for (String sentence : song) {
            try {
                // Mettre le thread en pause pendant 1000 millisecondes (1 seconde)
                Thread.sleep(1000);
                // Afficher la phrase dans la console avec une tabulation en début
                System.out.println('\t' + sentence);
            } catch (InterruptedException e) {
                // Capturer et relancer une RuntimeException si le thread est interrompu pendant la pause
                throw new RuntimeException(e);
            }
        }
    }
}