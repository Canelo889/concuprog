package VCyclicBarrierPDG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class TestingCyclicBarrier_PDG {
    private static int NUM_TEAMS = 20;

    public static void main(String[] args) {
        // List to store the results of each team
        List<Result> results = Collections.synchronizedList(new ArrayList<>());

        // CyclicBarrier with a runnable task (Referee) to execute when all threads reach the barrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM_TEAMS, new Referee(results));

        System.out.println("Starting PDG with " + NUM_TEAMS + " teams ");
        for (int i = 0; i < NUM_TEAMS; i++) {
            // Create and start a thread for each team
            Thread team = new Thread(new TeamThread(cyclicBarrier, results));
            team.setName("Team " + i);
            team.start();
        }
    }
}
