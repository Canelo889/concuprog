package Pattern.MVC;

import Pattern.MVC.controller.BeatController;
import Pattern.MVC.controller.ControllerInterface;
import Pattern.MVC.model.BeatModel;
import Pattern.MVC.model.BeatModelInterface;
import Pattern.MVC.view.DJView;
import Pattern.MVC.view.SimpleDJView;
import Pattern.MVC.view.View;

import java.util.Scanner;

public class DJTestDrive {

    public static void main (String[] args) {
        int userInput;
        BeatModelInterface model = new BeatModel();

        Scanner sc = new Scanner(System.in);

        /* Possible actions:
            0. GUI DJView
            1. Simple Textual DJView
         */
        System.out.println("In which mode do you want to run the DJView ?");
        System.out.println("0. GUI Standard");
        System.out.println("1. Textual");

        userInput = sc.nextInt();

        // Running the GUI mode
        if (userInput == 0) {
            View view = new DJView(model);
            ControllerInterface controller = new BeatController(model, view);
        } else {
            // Running the Text mode
            SimpleDJView view = new SimpleDJView(model);
            ControllerInterface controller = new BeatController(model, view);
            while (true) {
                view.actionPerformed(view.getUserInput());
            }
        }
    }
}