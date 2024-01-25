package Q4ForkJoinConcurrentArray;

import java.util.Random;
import java.util.concurrent.*;

public class ConcurrentArraySum {
    public static void main(String[] args) {
        // Définir la taille du tableau en fonction de vos besoins
        int arraySize = 100000000;
        long[] array = new long[arraySize];

        Random random = new Random();
        // Initialiser le tableau avec des valeurs (par exemple, des nombres aléatoires)
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(1000); // Écrire un nombre entier aléatoire inférieur à 1000
        }

        // Créer un pool ForkJoin
        ForkJoinPool pool = new ForkJoinPool();
        // Créer une tâche ArraySumTask pour calculer la somme de manière concurrente
        ArraySumTask task = new ArraySumTask(array, 0, array.length);
        // Invoker la tâche dans le pool ForkJoin et récupérer le résultat
        long totalSum = pool.invoke(task);

        // Afficher les résultats
        System.out.println("Taille du tableau : " + arraySize);
        System.out.println("Somme concurrente : " + totalSum);
    }
}
