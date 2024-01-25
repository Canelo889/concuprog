package PExecutorDrum;

// Déclaration de la classe Drum
public class Drum implements Runnable {
    // Nom de l'instrument (tambour)
    private String instrumentName;

    // Constructeur prenant le nom de l'instrument en tant que paramètre
    public Drum(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    // Méthode run() qui sera exécutée lorsque le thread est démarré
    @Override
    public void run() {
        // Affichage du message indiquant que l'instrument est joué
        System.out.println("Playing " + instrumentName);
    }
}
