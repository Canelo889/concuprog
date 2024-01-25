package OReentrantWithConditions;

public class TestingReeantrantLockWithConditions {
    public static void main(String[] args) {
        LockedWithConditionsStack stack = new LockedWithConditionsStack(5);
        (new Thread(new NumberProducer(stack))).start();
        (new Thread(new NumberConsumer(stack))).start();
    }
}
