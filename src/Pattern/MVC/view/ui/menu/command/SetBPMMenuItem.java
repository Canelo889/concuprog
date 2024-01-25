package Pattern.MVC.view.ui.menu.command;

import Pattern.MVC.controller.ControllerInterface;
import Pattern.MVC.view.ui.textPannel.IntElement;

public class SetBPMMenuItem extends MenuItemCommand {
    private IntElement bpmValueLabel;
    public SetBPMMenuItem(ControllerInterface controller, IntElement bpmValueLabel) {
        super("Set BPM", controller);
        this.bpmValueLabel = bpmValueLabel;
    }

    @Override
    public void execute() {
        controller.setBPM(bpmValueLabel.getValue());
    }
}
