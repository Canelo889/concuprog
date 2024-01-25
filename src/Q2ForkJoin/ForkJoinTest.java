package Q2ForkJoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
    public static void main(String[] args) {
        // Chanson de Georges Brassens
        String song = "Georges Brassens (1964) - Les Copains d'abord"
                + "Non, ce n'était pas le radeau"
                + "De la Méduse, ce bateau"
                + "Qu'on se le dise au fond des ports"
                + "Dise au fond des ports"
                + "Il naviguait en père peinard"
                + "Sur la grand-mare des canards"
                + "Et s'appelait les Copains d'abord"
                + "Les Copains d'abord";

        // Obtient le nombre de processeurs disponibles sur la machine
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available processors: " + processors);

        // Crée un ForkJoinPool avec le nombre de processeurs disponibles
        ForkJoinPool pool = new ForkJoinPool(processors);

        // Mesure le temps d'exécution de la tâche Fork/Join
        long startTime = System.currentTimeMillis();
        pool.invoke(new CustomRecursiveAction(song));
        long endTime = System.currentTimeMillis();

        System.out.println("Fork/Join tasks took "
                + (endTime - startTime)
                + " milliseconds.");
    }
}
