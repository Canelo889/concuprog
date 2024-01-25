package S1ConcurrentHashMap;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

// La classe Cow représente une vache qui mange de la nourriture provenant de boîtes dans un enclos
public class Cow implements Runnable {
    private String name;
    private ConcurrentHashMap<String, String> animalStallMap;
    private Random random = new Random();

    // Constructeur de la classe Cow
    public Cow(String name, ConcurrentHashMap<String, String> animalStallMap) {
        this.name = name;
        this.animalStallMap = animalStallMap;
    }

    // Méthode run, exécutée lorsqu'un thread est démarré
    @Override
    public void run() {
        while (true) {
            // Manger dans une boîte au hasard
            String food = animalStallMap.remove("box" + random.nextInt(10));
            System.out.println(name + " ate " + (food == null ? "nothing" : food));

            try {
                // Pause aléatoire simulant un temps entre deux repas
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                // Gestion d'une éventuelle interruption de thread avec une RuntimeException
                throw new RuntimeException(e);
            }
        }
    }
}
