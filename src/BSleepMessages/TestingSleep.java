package BSleepMessages;

public class TestingSleep {
    public static void main(String[] args) {
        // Pausing the execution with sleep:
        (new Thread(new SleepMessages())).start();
    }
}
