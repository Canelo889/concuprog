package Pattern.Singleton.Sensor_manager;

public class SimpleSingletonSensorsManager extends SingletonSensorManager {

    private static SingletonSensorManager instance;

    private SimpleSingletonSensorsManager() {
        super();
    }

    public static SingletonSensorManager getInstance() {
        if (instance == null) {
            instance = new SimpleSingletonSensorsManager();
        }
        return instance;
    }
}
