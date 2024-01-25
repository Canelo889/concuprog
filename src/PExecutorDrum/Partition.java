package PExecutorDrum;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Classe principale Partition
public class Partition {
    public static void main(String[] args) {
        // Création d'instances de la classe Drum représentant différents instruments de batterie
        Drum bassDrum = new Drum("Bass Drum");
        Drum floortom = new Drum("Floor Tom");
        Drum snareDrum = new Drum("Snare Drum");
        Drum rackTom = new Drum("Rack Tom");
        Drum hiHat = new Drum("Hi-Hat");
        Drum crashCymbal = new Drum("Crash Cymbal");
        Drum rideCymbal = new Drum("Ride Cymbal");
        Drum splashCymbal = new Drum("Splash Cymbal");
        Drum chinaCymbal = new Drum("China Cymbal");

        // Création d'un ScheduledExecutorService avec 9 threads dans le pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(9);

        // Paramètres pour la planification des instruments
        int initialDelay = 1000; // Délai initial avant le début de la planification
        int quaver = 500; // Intervalle de temps pour une croche (quaver)
        int crotchet = 1000; // Intervalle de temps pour une noire (crotchet)
        int minim = 2000; // Intervalle de temps pour une blanche (minim)
        TimeUnit unit = TimeUnit.MILLISECONDS; // Unité de temps (millisecondes)

        // Planification des instruments à des intervalles spécifiques
        executor.scheduleAtFixedRate(bassDrum, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(floortom, initialDelay, crotchet, unit);
        executor.scheduleAtFixedRate(snareDrum, initialDelay, crotchet, unit);
        executor.scheduleAtFixedRate(rackTom, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(bassDrum, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(hiHat, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(crashCymbal, initialDelay, crotchet, unit);
        executor.scheduleAtFixedRate(rideCymbal, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(splashCymbal, initialDelay, minim, unit);
        executor.scheduleAtFixedRate(chinaCymbal, initialDelay, minim, unit);
    }
}
