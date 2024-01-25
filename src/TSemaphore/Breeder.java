package TSemaphore;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class Breeder implements Runnable {
    private Semaphore[] bowlsSemaphores; // Tableau de sémaphores représentant les bols
    private String name; // Nom de l'éleveur
    private Random random = new Random(); // Générateur de nombres aléatoires

    public Breeder(String name, Semaphore[] bowlsSemaphores) {
        this.name = name;
        this.bowlsSemaphores = bowlsSemaphores;
    }

    @Override
    public void run() {
        Semaphore semaphore;
        int bowlNumber;
        while (true) {
            // Met de la nourriture dans l'un des bols de manière aléatoire
            bowlNumber = random.nextInt(3);
            semaphore = bowlsSemaphores[bowlNumber];
            try {
                semaphore.acquire(); // Acquérir le sémaphore du bol choisi
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " met de la nourriture dans le bol " + bowlNumber);
            semaphore.release(); // Libérer le sémaphore du bol après avoir mis la nourriture
        }
    }
}
