package Q4ForkJoinConcurrentArray;

import java.util.concurrent.*;

// La classe ArraySumTask calcule la somme des éléments d'un tableau en utilisant Fork-Join
class ArraySumTask extends RecursiveTask<Long> {
    // Ajuster le seuil en fonction des besoins
    private static final int THRESHOLD = 1000;

    // Le tableau sur lequel la tâche doit travailler
    private final long[] array;
    // Indice de début de la plage à traiter
    private final int start;
    // Indice de fin de la plage à traiter
    private final int end;

    // Constructeur de la tâche
    public ArraySumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    // Méthode principale pour effectuer le calcul
    @Override
    protected Long compute() {
        // Si la taille de la plage est inférieure ou égale au seuil, calcule directement la somme
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Sinon, divise la plage en deux sous-plages
            int mid = start + (end - start) / 2;

            // Crée une tâche pour la sous-plage de gauche
            ArraySumTask leftTask = new ArraySumTask(array, start, mid);
            // Crée une tâche pour la sous-plage de droite
            ArraySumTask rightTask = new ArraySumTask(array, mid, end);

            // Fork la tâche de gauche pour être exécutée en parallèle
            leftTask.fork();
            // Calcule la sous-tâche de droite de manière récursive
            long rightResult = rightTask.compute();
            // Attend que la tâche de gauche soit terminée et récupère son résultat
            long leftResult = leftTask.join();

            // Combine les résultats des deux sous-tâches
            return leftResult + rightResult;
        }
    }
}
