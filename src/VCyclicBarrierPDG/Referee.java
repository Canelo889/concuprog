package VCyclicBarrierPDG;

import java.util.Collections;
import java.util.List;

/**
 * This class represents the referee during the "Patrouille des Glaciers" contest.
 * The class is a thread simulating the behavior of the referee during the competition
 * by creating the final ranking of the teams. It uses the time taken by each team
 * to reach the end of the race to sort them.
 */
class Referee implements Runnable {
    private List<Result> results;

    // Constructor to initialize the Referee with the list of results
    public Referee(List<Result> results) {
        this.results = results;
    }

    @Override
    public void run() {
        // Referee starts to establish ranking
        System.out.println("Referee starts to establish ranking...");

        // Sort the results based on the time taken by each team
        Collections.sort(results);

        // Display the PDG Team Ranking
        System.out.println("PDG Team Ranking: ");
        for (Result r : results)
            System.out.println(r.getTeam() + " : " + r.getTime() + "h");
    }
}
