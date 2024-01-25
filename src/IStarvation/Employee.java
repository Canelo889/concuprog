package IStarvation;

// Déclaration de la classe Employee qui étend la classe Thread
public class Employee extends Thread {
    // Variables pour stocker le nom de l'employé, la salle, et un facteur d'utilisation du temps exagéré
    private String name;
    private String room;
    private int exaggeratedTimeUsageFactor;

    // Constructeur de la classe, prenant le nom de l'employé, la salle, et le facteur d'utilisation du temps en tant que paramètres
    public Employee(String name, String room, int exaggeratedTimeUsageFactor) {
        this.name = name;
        this.room = room;
        this.exaggeratedTimeUsageFactor = exaggeratedTimeUsageFactor;
    }

    // Méthode pour simuler l'utilisation de la salle par l'employé
    public void useRoom(int time) {
        // Bloc synchronisé sur la salle pour éviter les conflits d'utilisation concurrente
        synchronized (room) {
            System.out.println(name + " uses room for " + time + " seconds.");
            try {
                // Pause pour simuler l'utilisation de la salle
                Thread.sleep(time);
            } catch (InterruptedException e) {
                // Capturer et relancer une RuntimeException si le thread est interrompu pendant la pause
                throw new RuntimeException(e);
            }
        }
    }

    // Implémentation de la méthode run() de la classe Thread
    @Override
    public void run() {
        // Affichage du démarrage du thread
        System.out.println(name + " thread started.");

        // Boucle infinie simulant l'utilisation continue de la salle par l'employé
        while (true) {
            // Appel de la méthode useRoom pour simuler l'utilisation de la salle pendant un certain temps
            useRoom(100 * exaggeratedTimeUsageFactor);
        }
    }
}
