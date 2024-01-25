package WexchangerGarage;

import java.util.concurrent.Exchanger;

// La classe Customer représente un client qui échange sa voiture avec un atelier de réparation.
public class Customer implements Runnable {
    private String name;           // Le nom du client.
    private Car car;               // La voiture du client.
    private Exchanger<Car> exchanger;  // Exchanger utilisé pour l'échange de voitures avec l'atelier.

    // Constructeur de la classe Customer.
    public Customer(String name, Car car, Exchanger<Car> exchanger) {
        this.name = name;
        this.car = car;
        this.exchanger = exchanger;
    }

    // Méthode run() qui sera exécutée lorsque le thread du client est démarré.
    @Override
    public void run() {
        try {
            // Le client donne sa voiture pour réparation et reçoit une voiture de remplacement.
            Car replacementCar = exchanger.exchange(car);
            System.out.println(name + " a donné sa voiture " + car + " pour réparation et a reçu une " + replacementCar + " en remplacement pendant la journée de réparation.");

            // Le client rend la voiture de remplacement et récupère sa voiture réparée.
            car = exchanger.exchange(replacementCar);
            System.out.println(name + " a rendu la voiture de remplacement " + replacementCar + " et a récupéré sa voiture " + car);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
