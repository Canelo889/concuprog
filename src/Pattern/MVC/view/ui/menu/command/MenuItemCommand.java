package Pattern.MVC.view.ui.menu.command;

import Pattern.MVC.controller.ControllerInterface;

public abstract class MenuItemCommand {
    protected String label;
    protected ControllerInterface controller;

    public MenuItemCommand(String label, ControllerInterface controller) {
        this.label = label;
        this.controller = controller;
    }

    public abstract void execute();

    @Override
    public String toString() {
        return label;
    }
}
