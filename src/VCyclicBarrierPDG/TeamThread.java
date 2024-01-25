package VCyclicBarrierPDG;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * This class represents a team taking part in the "Patrouille des Glaciers" contest.
 * The class is a thread simulating the behavior of the team during the competition by waiting
 * for a random amount of time that represents the time that the team required to reach the end.
 */
public class TeamThread implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private List<Result> results;

    /**
     * Constructor to initialize the TeamThread with a cyclic barrier and a list of results.
     *
     * @param cyclicBarrier The cyclic barrier for synchronization among teams.
     * @param results       The list to store the results of the teams.
     */
    public TeamThread(CyclicBarrier cyclicBarrier, List<Result> results) {
        this.cyclicBarrier = cyclicBarrier;
        this.results = results;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": Started the race");

        Random random = new Random();
        int time = random.nextInt(30) + 1; // Random time between 1 and 30 hours

        Result result = new Result(name, time);
        results.add(result);
        try {
            System.out.println(name + ": Finished the race in " + time + " hours and is waiting for other teams");
            cyclicBarrier.await(); // Waiting for other teams to finish
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
