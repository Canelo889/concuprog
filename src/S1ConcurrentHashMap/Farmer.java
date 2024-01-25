package S1ConcurrentHashMap;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

// La classe Farmer représente un fermier qui place de la nourriture dans des boîtes dans un enclos
public class Farmer implements Runnable {
    private ConcurrentHashMap<String, String> animalStallMap;
    private String name;
    private Random random = new Random();

    // Constructeur de la classe Farmer
    public Farmer(String name, ConcurrentHashMap<String, String> animalStallMap) {
        this.name = name;
        this.animalStallMap = animalStallMap;
    }

    // Méthode run, exécutée lorsqu'un thread est démarré
    @Override
    public void run() {
        while (true) {
            // Placer de la nourriture dans une boîte au hasard
            String foodUnits = random.nextInt(100) + " food units";
            String chosenBox = "box" + random.nextInt(10);

            // Utiliser putIfAbsent pour éviter de remplacer la nourriture existante dans la boîte
            animalStallMap.putIfAbsent(chosenBox, foodUnits);

            // Afficher le message indiquant que le fermier a mis de la nourriture dans une boîte
            System.out.println(name + " put " + foodUnits + " into " + chosenBox);

            try {
                // Pause aléatoire simulant le temps entre deux actions du fermier
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                // Gestion d'une éventuelle interruption de thread avec une RuntimeException
                throw new RuntimeException(e);
            }
        }
    }
}
