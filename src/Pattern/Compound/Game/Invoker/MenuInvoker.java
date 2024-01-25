package Pattern.Compound.Game.Invoker;

import Pattern.Compound.Game.Command.CmdEnd;
import Pattern.Compound.Game.Command.CmdMove;
import Pattern.Compound.Game.Command.CmdSetWinner;
import Pattern.Compound.Game.Command.Command;
import Pattern.Compound.Game.Context.ValaisGame;

import java.util.ArrayList;
import java.util.List;

public class MenuInvoker {
    public List<Command> commands = new ArrayList<Command>();

    public MenuInvoker(ValaisGame valaisGame) {
        commands.add(new CmdEnd(valaisGame));
        commands.add(new CmdSetWinner(valaisGame));
        commands.add(new CmdMove(valaisGame));
    }

    public void callItem(int index) {
        commands.get(index).execute();
    }
}

