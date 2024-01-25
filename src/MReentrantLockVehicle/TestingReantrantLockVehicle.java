package MReentrantLockVehicle;

// Déclaration de la classe TestingReantrantLockVehicle
public class TestingReantrantLockVehicle {
    public static void main(String[] args) {
        // Création d'un objet Vehicle
        Vehicle vehicle = new Vehicle();

        // Création d'objets User (Romeo et Juliette) partageant le même véhicule
        User husband = new User("Romeo", vehicle);
        User wife = new User("Juliette", vehicle);

        // Création de deux threads distincts pour les utilisateurs Romeo et Juliette
        (new Thread(husband)).start();
        (new Thread(wife)).start();
    }
}
