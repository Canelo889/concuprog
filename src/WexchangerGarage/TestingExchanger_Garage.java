package WexchangerGarage;

import java.util.concurrent.Exchanger;

public class TestingExchanger_Garage {
    public static void main(String[] args) {
        Exchanger<Car> exchanger = new Exchanger<Car>();
        new Thread(new Customer("David", new Car("VW ID.4"), exchanger)).start();
        new Thread(new Garage(exchanger)).start();
    }
}
