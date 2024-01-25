package Pattern.Observer.Monitoring;

import Pattern.Observer.Monitoring.monitor.MedicalEmployee;
import Pattern.Observer.Monitoring.monitor.PatientMonitoring;

/**
 *
 * @author scz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PatientMonitoring pm = new PatientMonitoring(1, 140,85);

        MedicalEmployee jean = new MedicalEmployee("Jean    ", pm);
        MedicalEmployee pauline = new MedicalEmployee("Pauline ", pm);
        MedicalEmployee matthieu = new MedicalEmployee("Matthieu", pm);
        MedicalEmployee symeon = new MedicalEmployee("Symeon  ", pm);

        pm.setBloodPressure(110);
        pm.setPosition(3);

        pm.setPulseOximetry(90);
        pm.setPulseOximetry(70);
        pm.setPosition(7);
        pm.setBloodPressure(150);

        pm.removeObserver(matthieu);
        pm.setBloodPressure(145);
        pm.setPosition(9);
    }
}
