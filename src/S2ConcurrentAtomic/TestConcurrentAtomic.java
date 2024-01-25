package S2ConcurrentAtomic;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class TestConcurrentAtomic {

    public static void main(String[] args) {
        final int arrayLength = 5;

        // Créez un tableau non atomique et un tableau atomique
        int[] nonAtomicArray = new int[arrayLength];
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(arrayLength);

        // Initialisez les valeurs des tableaux
        for (int i = 0; i < atomicArray.length(); i++) {
            nonAtomicArray[i] = i;
            atomicArray.set(i, i);
        }

        // Affichez les valeurs initiales
        System.out.println("Valeurs initiales du tableau atomique : " + atomicArray);
        System.out.println("Valeurs initiales du tableau non atomique : " + Arrays.toString(nonAtomicArray));

        System.out.println("Création de 3 threads pour incrémenter les valeurs de ces deux tableaux");

        // Créez 3 threads qui incrémenteront la valeur à l'indice 1
        Thread thread1 = new Thread(new Operation(atomicArray, nonAtomicArray));
        Thread thread2 = new Thread(new Operation(atomicArray, nonAtomicArray));
        Thread thread3 = new Thread(new Operation(atomicArray, nonAtomicArray));

        // Démarrer les threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Attendez que les threads se terminent
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Affichez les valeurs finales
        System.out.println("Valeurs finales du tableau atomique : " + atomicArray);
        System.out.println("Valeurs finales du tableau non atomique : " + Arrays.toString(nonAtomicArray));
    }
}
