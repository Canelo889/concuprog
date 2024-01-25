package UCountDownLatch;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private List<String> suitcases = new ArrayList<String>();

    // Ajoute une valise à la liste
    public void addSuitcase(String suitcase) {
        suitcases.add(suitcase);
    }

    // Imprime le contenu du véhicule
    public void printVehicleContent() {
        System.out.println("Vehicle content: " + suitcases);
    }
}
