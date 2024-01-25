package TSemaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Dog implements Runnable {
    private String name; // Nom du chien
    private Semaphore[] bowlsSemaphores; // Tableau de sémaphores représentant les bols
    private Random random = new Random(); // Générateur de nombres aléatoires

    public Dog(String name, Semaphore[] bowlsSemaphores) {
        this.name = name;
        this.bowlsSemaphores = bowlsSemaphores;
    }

    @Override
    public void run() {
        Semaphore semaphore;
        int bowlNumber;
        while (true) {
            // Mange dans l'un des bols de manière aléatoire
            bowlNumber = random.nextInt(3);
            semaphore = bowlsSemaphores[bowlNumber];
            try {
                semaphore.acquire(); // Acquérir le sémaphore du bol choisi
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " mange dans le bol " + bowlNumber);
            semaphore.release(); // Libérer le sémaphore du bol après avoir mangé
        }
    }
}
