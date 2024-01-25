package Pattern.MVC.view.ui.menu.command;

import Pattern.MVC.controller.ControllerInterface;

public class QuitMenuItem extends MenuItemCommand {
    public QuitMenuItem(ControllerInterface controller) {
        super("Quit", controller);
    }

    @Override
    public void execute() {
        controller.stop();
    }
}
