package H2DeadlockBridge;

// Déclaration de la classe Vehicle qui implémente l'interface Runnable
public class Vehicle implements Runnable {
    // Variables pour stocker le nom du véhicule, le pont et la route
    String name;
    private Bridge bridge;
    private Road road;

    // Constructeur de la classe, prenant le nom du véhicule, le pont et la route en tant que paramètres
    public Vehicle(String name, Bridge bridge, Road road) {
        this.name = name;
        this.bridge = bridge;
        this.road = road;
    }

    // Implémentation de la méthode run() de l'interface Runnable
    @Override
    public void run() {
        // Actions pour traverser le pont
        // Verrouillage synchronisé sur la route
        synchronized (road) {
            System.out.println(name +
                    " is entering on the one-way bridge from "
                    + road);

            // Verrouillage synchronisé sur l'autre côté du pont
            synchronized (road == bridge.getRoadEast() ?
                    bridge.getRoadWest():
                    bridge.getRoadEast()) {
                System.out.println(name + " is leaving the one-way bridge");
            }
        }
    }
}
