package Pattern.Compound.Game.Strategy;

public class StrategyZermatt implements StrategyGame {

    @Override
    public void move() {
        System.out.println("Driving to Zermatt.");
    }

    @Override
    public void end() {
        System.out.println("Ending the Zermatt game.");
    }

    @Override
    public void setWinner() {
        System.out.println("Deciding about the winner of Zermatt game.");
    }
}
