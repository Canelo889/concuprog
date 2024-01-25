package Pattern.Observer.Monitoring.monitor;


import Pattern.Observer.Monitoring.observer.Observer;
import Pattern.Observer.Monitoring.observer.Problem;
import Pattern.Observer.Monitoring.observer.Subject;

/**
 * @author  scz
 */
public class MedicalEmployee implements Observer {

    private String name;

    public MedicalEmployee(String name, Subject subject) {
        this.name = name;
        subject.registerObserver(this);
    }

    public void update(int position, Problem p, int bloodPressure , int pulseOximetry) {
        System.out.print("Employee " + name + " receives notification: ");
        System.out.println("Position " + position + " observer.Problem " + p + " BloodPressure " + bloodPressure + " PulseOximetry " + pulseOximetry);
    }


}
