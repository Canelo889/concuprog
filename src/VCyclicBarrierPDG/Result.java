package VCyclicBarrierPDG;

/**
 * This class represents the result of a team in the "Patrouille des Glaciers" contest.
 * It implements Comparable to allow sorting of results based on the time taken by each team.
 */
public class Result implements Comparable<Result> {
    private final int time;
    private final String team;

    /**
     * Constructor to initialize the Result with the team name and time taken.
     *
     * @param team The name of the team.
     * @param time The time taken by the team to complete the competition.
     */
    public Result(String team, int time) {
        this.time = time;
        this.team = team;
    }

    /**
     * Get the time taken by the team.
     *
     * @return The time taken by the team.
     */
    public int getTime() {
        return time;
    }

    /**
     * Get the name of the team.
     *
     * @return The name of the team.
     */
    public String getTeam() {
        return team;
    }

    /**
     * Compare two results based on the time taken.
     *
     * @param result The result to compare with.
     * @return A negative integer, zero, or a positive integer as this object is less than,
     *         equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Result result) {
        return this.getTime() - result.getTime();
    }
}
