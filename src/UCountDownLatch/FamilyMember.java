package UCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class FamilyMember implements Runnable {
    String name;
    private Vehicle vehicle;
    private CountDownLatch countDownLatch;

    // Constructeur avec le nom du membre de la famille, le véhicule et le CountDownLatch
    public FamilyMember(String name, Vehicle vehicle, CountDownLatch countDownLatch) {
        this.name = name;
        this.vehicle = vehicle;
        this.countDownLatch = countDownLatch;
    }

    // Méthode exécutée lorsque le thread est démarré
    @Override
    public void run() {
        // Ajoute une valise au véhicule avec le nom du membre de la famille
        this.vehicle.addSuitcase(name + "'s suitcase");

        // Décrémente le CountDownLatch
        countDownLatch.countDown();
    }
}
