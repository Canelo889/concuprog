package Pattern.Singleton.Sensor_manager;

public class SynchSingletonSensorsManager extends SingletonSensorManager {

    private static SingletonSensorManager instance;

    private SynchSingletonSensorsManager() {
        super();
    }

    public static synchronized SingletonSensorManager getInstance() {
        if (instance == null) {
            instance = new SynchSingletonSensorsManager();
        }
        return instance;
    }
}
