package RBlockingQueue;

import java.util.Random;

public class Customer implements Runnable {
    private String name;
    private PostOffice postOffice;

    public Customer(String name, PostOffice postOffice) {
        this.name = name;
        this.postOffice = postOffice;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                // Le client attend un temps aléatoire avant de générer un colis
                Thread.sleep(random.nextInt(1000));

                // Le client génère un nouveau colis et l'enregistre au bureau de poste
                postOffice.register(new Package(this));
            } catch (InterruptedException e) {
                // Gérer les exceptions d'interruption
                throw new RuntimeException(e);
            }
        }
    }
}
