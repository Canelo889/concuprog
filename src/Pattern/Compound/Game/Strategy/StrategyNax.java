package Pattern.Compound.Game.Strategy;

public class StrategyNax implements StrategyGame {

    @Override
    public void move() {
        System.out.println("Moving to Nax via ferrata.");
    }

    @Override
    public void end() {
        System.out.println("Arriving at the end of the Nax via ferrata");
    }

    @Override
    public void setWinner() {
        System.out.println("Nax winner game is set.");
    }
}
