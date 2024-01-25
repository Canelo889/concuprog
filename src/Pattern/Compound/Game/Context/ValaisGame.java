package Pattern.Compound.Game.Context;

import Pattern.Compound.Game.Strategy.StrategyGame;

public  class ValaisGame  {
    public StrategyGame gameStragegy;

    public void setGameStragegy(StrategyGame gameStragegy) {
        this.gameStragegy = gameStragegy;
    }

    public void end() {
        gameStragegy.end();
    }

    public void move() {
        gameStragegy.move();
    }

    public void setWinner(){
        gameStragegy.setWinner();
    }

}
