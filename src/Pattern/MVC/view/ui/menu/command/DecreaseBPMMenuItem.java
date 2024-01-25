package Pattern.MVC.view.ui.menu.command;

import Pattern.MVC.controller.ControllerInterface;

public class DecreaseBPMMenuItem extends MenuItemCommand {
    public DecreaseBPMMenuItem(ControllerInterface controller) {
        super("Deacrease", controller);
    }

    @Override
    public void execute() {
        controller.decreaseBPM();
    }
}
