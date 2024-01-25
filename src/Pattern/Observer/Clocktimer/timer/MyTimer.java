package Pattern.Observer.Clocktimer.timer;

import Pattern.Observer.Clocktimer.observer.Observer;
import Pattern.Observer.Clocktimer.observer.Subject;


import java.util.*;

public class MyTimer implements ClockTimer, Subject {

    // http://www.exampledepot.com/egs/java.util/GetCurTime.html
    private Calendar cal;
    private final Timer timer;
    private final List<Observer> observers;

    /**
     * Constructor
     */
    public MyTimer() {
        observers = new ArrayList<Observer>();
        cal = Calendar.getInstance();
        timer = new Timer();

        timer.schedule(new TimerAction(), 0, 1000);
    }

    // http://www.journaldunet.com/developpeur/tutoriel/jav/050623-java-repetition-timer-timertask.shtml
    class TimerAction extends TimerTask {
        public void run() {
            cal = Calendar.getInstance();
            tick();
        }
    }

    public int getHour() {
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute() {
        return cal.get(Calendar.MINUTE);
    }

    public int getSecond() {
        return cal.get(Calendar.SECOND);
    }

    public void tick() {
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(getHour(), getMinute(), getSecond());
        }
    }
}