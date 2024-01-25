package Pattern.Observer.Monitoring.observer;

/**
 *
 * @author scz
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
