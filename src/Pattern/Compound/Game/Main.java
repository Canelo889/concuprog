package Pattern.Compound.Game;

import Pattern.Compound.Game.Context.ValaisGame;
import Pattern.Compound.Game.Invoker.MenuInvoker;
import Pattern.Compound.Game.Strategy.StrategyNax;
import Pattern.Compound.Game.Strategy.StrategyNendaz;
import Pattern.Compound.Game.Strategy.StrategyZermatt;

public class Main {
    public static void main(String[] args) {
        ValaisGame myGame = new ValaisGame();
        myGame.setGameStragegy(new StrategyNax());

        MenuInvoker menuInvoker = new MenuInvoker(myGame);
        menuInvoker.callItem(2);
        menuInvoker.callItem(1);
        menuInvoker.callItem(0);

        myGame.setGameStragegy(new StrategyNendaz());
        menuInvoker.callItem(2);
        menuInvoker.callItem(1);
        menuInvoker.callItem(0);

        myGame.setGameStragegy(new StrategyZermatt());
        menuInvoker.callItem(2);
        menuInvoker.callItem(1);
        menuInvoker.callItem(0);
    }
}