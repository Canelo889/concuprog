package H1Deadlock;

// Déclaration de la classe TestThreadWithDeadlock
public class TestThreadWithDeadlock {
    // Déclaration de deux objets utilisés comme verrous
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    // Méthode principale (main) du programme
    public static void main(String args[]) {
        // Création de deux threads de démonstration
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();

        // Démarrage des threads
        T1.start();
        T2.start();
    }

    // Classe interne représentant le premier thread de démonstration
    private static class ThreadDemo1 extends Thread {
        public void run() {
            // Bloc synchronisé sur Lock1
            synchronized (Lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    // Pause pour simuler un traitement
                    Thread.sleep(10);
                } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for lock 2...");

                // Bloc synchronisé sur Lock2
                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }

    // Classe interne représentant le deuxième thread de démonstration
    private static class ThreadDemo2 extends Thread {
        public void run() {
            // Bloc synchronisé sur Lock2
            synchronized (Lock2) {
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    // Pause pour simuler un traitement
                    Thread.sleep(10);
                } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for lock 1...");

                // Bloc synchronisé sur Lock1
                synchronized (Lock1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}
