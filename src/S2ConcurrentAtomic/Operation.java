package S2ConcurrentAtomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

// La classe Operation effectue des opérations d'incrémentation sur un tableau atomique et non atomique
public class Operation implements Runnable {

    private AtomicIntegerArray atomicArray;  // Tableau atomique pour les opérations atomiques
    private int[] nonAtomicArray;  // Tableau non atomique pour les opérations non atomiques
    private int maxLength;  // Longueur des tableaux

    // Constructeur prenant un tableau atomique et un tableau non atomique
    public Operation(AtomicIntegerArray atomicArray, int[] nonAtomicArray) {
        this.atomicArray = atomicArray;
        this.nonAtomicArray = nonAtomicArray;
        this.maxLength = atomicArray.length();
    }

    @Override
    public void run() {
        // Incrémente la valeur de chaque index 100000 fois
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < maxLength; j++) {
                // Opération d'incrémentation atomique sur le tableau atomique
                atomicArray.incrementAndGet(j);
                // Opération d'incrémentation non atomique sur le tableau non atomique
                nonAtomicArray[j]++;
            }
        }
    }
}
