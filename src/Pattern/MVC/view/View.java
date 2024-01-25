package Pattern.MVC.view;

import Pattern.MVC.controller.ControllerInterface;

public interface View {
    public void setController(ControllerInterface controller);
    public void createView();
    public void createControls();
    public void enableStopMenuItem();
    public void disableStopMenuItem();
    public void enableStartMenuItem();
    public void disableStartMenuItem();

}
