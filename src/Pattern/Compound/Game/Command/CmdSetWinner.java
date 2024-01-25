package Pattern.Compound.Game.Command;

import Pattern.Compound.Game.Context.ValaisGame;

public class CmdSetWinner implements Command {
    private ValaisGame valaisGame;

    public CmdSetWinner(ValaisGame valaisGame) {
        this.valaisGame = valaisGame;
    }

    @Override
    public void execute() {
        valaisGame.setWinner();
    }
}
