package Pattern.Observer.Clocktimer;

import Pattern.Observer.Clocktimer.clock.AnalogClock;
import Pattern.Observer.Clocktimer.clock.DigitalClock;
import Pattern.Observer.Clocktimer.timer.MyTimer;
import Pattern.Observer.Monitoring.observer.Subject;

public class Main {


    public static void main(String[] args) {
        MyTimer clockTimer = new MyTimer();

       new DigitalClock(clockTimer);
       new AnalogClock(clockTimer);

    }
}