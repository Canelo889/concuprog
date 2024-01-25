package Pattern.Compound.Game.Strategy;

public class StrategyNendaz implements StrategyGame {

    @Override
    public void move() {
        System.out.println("Moving to Nendaz Tracuit.");
    }

    @Override
    public void end() {
        System.out.println("This is the end of the Nendaz game.");
    }

    @Override
    public void setWinner() {
        System.out.println("Setting the winner of the Nendaz game");
    }
}
