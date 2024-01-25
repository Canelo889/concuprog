package H2DeadlockBridge;

public class Road {
    private String position;

    public Road(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return position + " road";
    }
}
