package Pattern.MVC.view.ui.menu.command;

import Pattern.MVC.controller.ControllerInterface;
import Pattern.MVC.view.ui.menu.Colors;

public class StartMenuItem extends MenuItemCommand {
    private boolean enabled = true;
    public StartMenuItem(ControllerInterface controller) {
        super("Start", controller);
    }

    @Override
    public void execute() {
        if(enabled) {
            this.controller.start();
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
