package Pattern.MVC.view.ui.menu.command;

import Pattern.MVC.controller.ControllerInterface;

public class IncreaseBPMMenuItem extends MenuItemCommand {
    public IncreaseBPMMenuItem(ControllerInterface controller) {
        super("Increase", controller);
    }

    @Override
    public void execute() {
        controller.increaseBPM();
    }
}
