package Pattern.Singleton.Sensor_manager;

public class DbleCheckedLockingSingletonSensorsManager extends SingletonSensorManager {

    private static SingletonSensorManager instance;

    private DbleCheckedLockingSingletonSensorsManager() {
        super();
    }

    public static SingletonSensorManager getInstance() {
        if (instance == null) {
            synchronized (DbleCheckedLockingSingletonSensorsManager.class) {
                if (instance == null) {
                    instance = new DbleCheckedLockingSingletonSensorsManager();
                }
            }
        }
        return instance;
    }

}
