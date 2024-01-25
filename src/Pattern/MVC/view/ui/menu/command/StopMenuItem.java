package Pattern.MVC.view.ui.menu.command;

import Pattern.MVC.controller.ControllerInterface;
import Pattern.MVC.view.ui.menu.Colors;

public class StopMenuItem extends MenuItemCommand {
    private boolean enabled = false;
    public StopMenuItem(ControllerInterface controller) {
        super("Stop", controller);
    }

    @Override
    public void execute() {
        if(enabled) {
            controller.stop();
        }
    }


    public void setEnabled(boolean b) {
        this.enabled = b;
    }

    @Override
    public String toString() {
        if(enabled) {
            return label;
        } else {
            return Colors.RED.getValue() + label + Colors.BLACK.getValue();
        }

    }
}
