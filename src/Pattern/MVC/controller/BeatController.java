package Pattern.MVC.controller;

import Pattern.MVC.model.BeatModelInterface;
import Pattern.MVC.view.View;

public class BeatController implements ControllerInterface {
    BeatModelInterface model;
    View view;

    public BeatController(BeatModelInterface model, View view) {
        this.model = model;
        this.view = view;
        view.setController(this);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.initialize();
    }

    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
    }

    public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }
}
