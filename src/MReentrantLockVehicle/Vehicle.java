package MReentrantLockVehicle;

import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

// Déclaration de la classe Vehicle
public class Vehicle {
    // Verrou réentrant pour contrôler l'accès concurrentiel à la méthode use
    private ReentrantLock reservationLock = new ReentrantLock();

    // Variable pour un compteur (pour illustrer l'accès concurrentiel)
    int counter = 0;

    // Méthode pour l'utilisation du véhicule, prenant le nom de l'utilisateur en tant que paramètre
    public void use(String name) {
        // Acquisition du verrou réentrant
        reservationLock.lock();
        try {
            // Section critique : code à exécuter de manière exclusive
            System.out.println(name + " is using the vehicle");
        } finally {
            // Libération du verrou réentrant dans le bloc finally pour garantir la libération même en cas d'exception
            System.out.println(name + " is releasing the vehicle");
            reservationLock.unlock();
        }
    }
}
