package UCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class TestingCountDownLatch_FamilyTrip {
    public static void main(String[] args) throws InterruptedException {
        // Crée un véhicule (Vehicle)
        Vehicle seatAlhambra = new Vehicle();

        // Affiche le contenu initial du véhicule
        seatAlhambra.printVehicleContent();

        // Liste des noms des membres de la famille
        String[] family = {"Jean", "Anna", "Joseph", "Martha", "Eleonore", "Paul", "Catarina"};

        // Crée un CountDownLatch avec le nombre de membres de la famille
        CountDownLatch countDownLatch = new CountDownLatch(family.length);

        // Pour chaque membre de la famille, démarre un thread avec un FamilyMember
        for (String name : family)
            new Thread(new FamilyMember(name, seatAlhambra, countDownLatch)).start();

        // Attend que tous les membres de la famille aient préparé leurs bagages (CountDownLatch atteint zéro)
        countDownLatch.await();

        // Affiche le contenu final du véhicule
        seatAlhambra.printVehicleContent();

        // Annonce que le voyage en famille peut commencer
        System.out.println("Family trip can start");
    }
}
