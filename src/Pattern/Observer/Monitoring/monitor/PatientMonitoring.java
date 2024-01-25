package Pattern.Observer.Monitoring.monitor;

import Pattern.Observer.Monitoring.observer.Observer;
import Pattern.Observer.Monitoring.observer.Problem;
import Pattern.Observer.Monitoring.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  scz
 */
public class PatientMonitoring implements Subject {

	private List<Observer> observers;

    private int bloodPressure;
    private int maxBloodPressure;
    private int pulseOximetry;
    private int maxPulseOximetry;
    private int position; // room number
    private Problem currentProblem;

    public PatientMonitoring(int startingPosition, int maxBloodPressure, int maxPulseOximetry) {
        observers = new ArrayList<Observer>();
        this.maxBloodPressure = maxBloodPressure;
        this.maxPulseOximetry = maxPulseOximetry;
        this.position = startingPosition;
        this.currentProblem = Problem.NO_PROBLEM;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        for (Observer o : observers)
            o.update(this.position, this.currentProblem, this.bloodPressure, this.pulseOximetry);
    }

    public void setBloodPressure(int newBloodPressure) {
		this.bloodPressure = newBloodPressure;
		if (newBloodPressure > maxBloodPressure) {
			this.currentProblem = Problem.BLOOD_PRESSURE;
			notifyObservers();
		}
	}

    public void setPulseOximetry(int newPulseOximetry) {
		this.pulseOximetry = newPulseOximetry;
		if (newPulseOximetry > maxPulseOximetry) {
			this.currentProblem = Problem.OXIMETRY;
			notifyObservers();
		}
	}

    public void setPosition(int position) {
		this.position = position;
	}


}
