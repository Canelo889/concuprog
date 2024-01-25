package MReentrantLockVehicle;

// Déclaration de la classe User qui implémente l'interface Runnable
public class User implements Runnable {
    // Variables pour stocker le nom de l'utilisateur et une référence au véhicule
    private String name;
    private Vehicle vehicle;

    // Constructeur de la classe, prenant le nom de l'utilisateur et une référence au véhicule en tant que paramètres
    public User(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    // Implémentation de la méthode run() de l'interface Runnable
    @Override
    public void run() {
        // Boucle infinie représentant le comportement continu de l'utilisateur
        while (true) {
            // L'utilisateur utilise le véhicule en appelant la méthode use() du véhicule
            vehicle.use(this.name);

            try {
                // Pause de 500 millisecondes entre chaque utilisation du véhicule
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Capturer et relancer une RuntimeException si le thread est interrompu pendant la pause
                throw new RuntimeException(e);
            }
        }
    }
}
