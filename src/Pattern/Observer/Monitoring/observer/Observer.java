package Pattern.Observer.Monitoring.observer;

/**
 *
 * @author scz
 */
public interface Observer {
    void update(int position, Problem p, int bloodPressure, int pulseOximetry);
}

