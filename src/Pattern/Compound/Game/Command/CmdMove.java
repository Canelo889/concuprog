package Pattern.Compound.Game.Command;


import Pattern.Compound.Game.Context.ValaisGame;

public class CmdMove implements Command {
    private ValaisGame valaisGame;

    public CmdMove(ValaisGame valaisGame) {
        this.valaisGame = valaisGame;
    }

    @Override
    public void execute() {
        valaisGame.move();
    }
}
