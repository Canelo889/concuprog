package Pattern.Singleton;

import Pattern.Singleton.Sensor_manager.SingletonSensorManager;
import Pattern.Singleton.Sensor_manager.DbleCheckedLockingSingletonSensorsManager;
import Pattern.Singleton.Sensor_manager.EagerSingletonSensorsManager;
import Pattern.Singleton.Sensor_manager.SimpleSingletonSensorsManager;
import Pattern.Singleton.Sensor_manager.SynchSingletonSensorsManager;
import Pattern.Singleton.Sensors.RoadConditionSensor;
import Pattern.Singleton.Sensors.SpeedSensor;
import Pattern.Singleton.Sensors.TemperatureSensor;

public class CarSensorSingletonLauncher {

    public CarSensorSingletonLauncher() {
    }

    public static void main(String[] args) {
        CarSensorSingletonLauncher launcher
                = new CarSensorSingletonLauncher();
        launcher.launch();
    }

    public void launch() {
        this.test(SimpleSingletonSensorsManager.getInstance());
        this.test(SynchSingletonSensorsManager.getInstance());
        this.test(EagerSingletonSensorsManager.getInstance());
        this.test(DbleCheckedLockingSingletonSensorsManager.getInstance());
    }

    private void test(SingletonSensorManager manager) {
        manager.addSensor(new TemperatureSensor());
        manager.addSensor(new SpeedSensor());
        manager.addSensor(new RoadConditionSensor());
        manager.printState();
    }
}
