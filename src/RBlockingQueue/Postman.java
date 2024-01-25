package RBlockingQueue;

public class Postman implements Runnable {
    private PostOffice postOffice;

    public Postman(PostOffice postOffice) {
        this.postOffice = postOffice;
    }

    @Override
    public void run() {
        while (true) {
            postOffice.takeForDelivery();
        }
    }
}
