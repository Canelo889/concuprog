package Pattern.MVC.view.ui.menu.invoker;

import Pattern.MVC.controller.ControllerInterface;
import Pattern.MVC.view.ui.TextualUIElement;
import Pattern.MVC.view.ui.menu.command.MenuItemCommand;

public class TextMenu implements TextualUIElement {
    private String label;
    private MenuItemCommand[] menuItems = new MenuItemCommand[6];

    private ControllerInterface controller;

    public TextMenu(String label, ControllerInterface controller) {
        this.label = label;
        this.controller = controller;
    }

    public void add(int key, MenuItemCommand menuItemCommand) {
        menuItems[key] = menuItemCommand;
    }

    public void callMenuItem(int key) {
        menuItems[key].execute();
    }

    @Override
    public String draw() {
        String output = "Menu + " + label + ":\n ";
        for(int i=0;i<menuItems.length;i++)
            output += "[" + i + "]" + menuItems[i] + "\n ";
        return output;
    }
}
