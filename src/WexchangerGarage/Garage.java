package WexchangerGarage;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadLocalRandom;

// La classe Garage représente un atelier de réparation de voitures.
public class Garage implements Runnable {
    private Car myCars[] = new Car[] {new Car("Seat Alhambra"),
            new Car("BMW Mini"),
            new Car("Tesla 3")};

    private Exchanger<Car> exchanger;  // Exchanger utilisé pour l'échange de voitures avec les clients.

    // Constructeur de la classe Garage.
    public Garage(Exchanger<Car> exchanger) {
        this.exchanger = exchanger;
    }

    // Méthode run() qui sera exécutée lorsque le thread de l'atelier est démarré.
    @Override
    public void run() {
        try {
            // Sélection aléatoire d'une voiture de remplacement disponible.
            int replacementCarAvailable = ThreadLocalRandom.current().nextInt(0, 2);

            // Le garage reçoit la voiture à réparer et fournit une voiture de courtoisie.
            Car carToRepair = exchanger.exchange(myCars[replacementCarAvailable]);
            System.out.println("Le garage a reçu la voiture " + carToRepair + " à réparer et a fourni une " + myCars[replacementCarAvailable] + " en voiture de courtoisie.");

            // Le garage répare la voiture et reçoit de retour la voiture de courtoisie.
            myCars[replacementCarAvailable] = exchanger.exchange(carToRepair);
            System.out.println("Le garage a réparé la voiture " + carToRepair + " et a reçu en retour la voiture de courtoisie " + myCars[replacementCarAvailable]);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
