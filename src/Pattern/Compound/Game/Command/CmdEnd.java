package Pattern.Compound.Game.Command;


import Pattern.Compound.Game.Context.ValaisGame;

public class CmdEnd implements Command {
    ValaisGame valaisGame;
    
    public CmdEnd(ValaisGame valaisGame) {
        this.valaisGame = valaisGame;
    }

    @Override
    public void execute() {
        valaisGame.end();
    }
}
