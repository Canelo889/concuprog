package IStarvation;

public class TestingStarvation {
    public static void main(String[] args) {
        System.out.println("Main thread Started");
        String sharedRoom = "Polaris";
        Employee t1 = new Employee("Emma", sharedRoom, 1);
        Employee t2 = new Employee("Thierry", sharedRoom, 100);
        t1.start();
        t2.start();
        System.out.println("Main thread Ended");
    }
}