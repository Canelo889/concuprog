package S1ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

// La classe TestingConcurrentHashMap_Farm teste la simulation d'une ferme avec des fermiers et des vaches
public class TestingConcurrentHashMap_Farm {
    public static void main(String[] args) {
        // Création d'une ConcurrentHashMap pour représenter les boîtes dans l'enclos
        ConcurrentHashMap<String, String> animalStallMap = new ConcurrentHashMap<>();

        // Démarrage de deux threads représentant deux fermiers (Verena et Pierre)
        new Thread(new Farmer("Verena", animalStallMap)).start();
        new Thread(new Farmer("Pierre", animalStallMap)).start();

        // Démarrage de neuf threads représentant neuf vaches (Cow1 à Cow9)
        for (int i = 1; i < 10; i++)
            new Thread(new Cow("Cow" + i, animalStallMap)).start();
    }
}
