package Pattern.MVC.view;

import Pattern.MVC.controller.ControllerInterface;
import Pattern.MVC.model.BeatModelInterface;
import Pattern.MVC.view.ui.menu.command.*;
import Pattern.MVC.view.ui.menu.invoker.TextMenu;
import Pattern.MVC.view.ui.textPannel.IntElement;
import Pattern.MVC.view.ui.textPannel.TextElement;
import Pattern.MVC.view.ui.textPannel.TextPanel;

import java.util.Scanner;

public class SimpleDJView implements View, BeatObserver, BPMObserver {
    private static final int NEWBPM = 0;
    private static final int INCREASE = 1;
    private static final int DECREASE = 2;
    private static final int START = 3;
    private static final int STOP = 4;
    private static final int QUIT = 5;

    private static final String OFFLINE_LABEL = "offline. ";
    private static final String CURRENT_BPM_SETTING = "Current BPM setting: ";
    private BeatModelInterface model;
    private ControllerInterface controller;
    private TextPanel viewPanel;
    private TextElement bpmOutputLabel;
    private IntElement bpmValueLabel;
    private TextPanel viewControl;

    private TextMenu menu;
    private SetBPMMenuItem setNewBPMMenuItem;
    private IncreaseBPMMenuItem increaseBPMMenuItem;
    private DecreaseBPMMenuItem decreaseBPMMenuItem;
    private StartMenuItem startMenuItem;
    private StopMenuItem stopMenuItem;
    private QuitMenuItem quitMenuItem;

    public SimpleDJView(BeatModelInterface model) {
        this.model = model;
        model.registerObserver((BeatObserver) this);
        model.registerObserver((BPMObserver) this);
    }

    @Override
    public void setController(ControllerInterface controller) {
        this.controller = controller;
    }

    public void createView() {
        // Create the first TextPanel
        viewPanel = new TextPanel("View");
        // ... with its output label
        bpmOutputLabel = new TextElement(OFFLINE_LABEL + CURRENT_BPM_SETTING);
        viewPanel.add(bpmOutputLabel);
        bpmValueLabel = new IntElement(model.getBPM());
        viewPanel.add(bpmValueLabel);
    }

    public void createControls() {
        // Create the first TextPanel
        viewControl = new TextPanel("Control");

        // Setup the menu and menu items
        menu = new TextMenu("DJ Control", controller);

        setNewBPMMenuItem = new SetBPMMenuItem(controller, bpmValueLabel);
        menu.add(NEWBPM, setNewBPMMenuItem);

        increaseBPMMenuItem = new IncreaseBPMMenuItem(controller);
        menu.add(INCREASE, increaseBPMMenuItem);

        decreaseBPMMenuItem = new DecreaseBPMMenuItem(controller);
        menu.add(DECREASE, decreaseBPMMenuItem);

        startMenuItem = new StartMenuItem(controller);
        menu.add(START, startMenuItem);

        stopMenuItem = new StopMenuItem(controller);
        menu.add(STOP, stopMenuItem);

        quitMenuItem = new QuitMenuItem(controller);
        menu.add(QUIT, quitMenuItem);

        // Add the menu to the view pannel
        viewControl.add(menu);
        System.out.println(viewControl.draw());
        System.out.println(viewPanel.draw());

    }

    public void enableStopMenuItem() {
        stopMenuItem.setEnabled(true);
    }

    public void disableStopMenuItem() {
        stopMenuItem.setEnabled(false);
    }

    public void enableStartMenuItem() {
        startMenuItem.setEnabled(true);
    }

    public void disableStartMenuItem() {
        startMenuItem.setEnabled(false);
    }

    public void actionPerformed(Tuple2 event) {
        if (event.first == QUIT) {
            System.exit(0);
        } else if (event.first == NEWBPM) {
            bpmValueLabel.update(event.second);
        }
        menu.callMenuItem(event.first);
        if (event.first == INCREASE || event.first == DECREASE)
        {
            bpmValueLabel.update(model.getBPM());
        }
        // Draw the panel
        System.out.println(viewControl.draw());
        System.out.println(viewPanel.draw());

    }

    public void updateBPM() {
        int bpm = model.getBPM();
        if (bpm == 0) {
            bpmOutputLabel.setText(OFFLINE_LABEL + CURRENT_BPM_SETTING);
        } else {
            bpmOutputLabel.setText(CURRENT_BPM_SETTING);
        }
    }

    public void updateBeat() {
    }

    private class Tuple2 {
        private int first = -1;
        private int second = -1;
        public Tuple2(int first, int second){
            this.first = first;
            this.second = second;
        }
    }


    public Tuple2 getUserInput() {
        Scanner sc = new Scanner(System.in);
        int output = sc.nextInt();
        int output2 = -1;
        if (output == NEWBPM) {
            System.out.print(" -> enter BPM Value ");
            output2 = sc.nextInt();
        }
        return new Tuple2(output, output2);
    }
}
