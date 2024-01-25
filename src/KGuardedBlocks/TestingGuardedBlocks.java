package KGuardedBlocks;

public class TestingGuardedBlocks {
    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice(10);
        (new Thread(new Postman(postOffice))).start();
        (new Thread(new Customer("Mrs Darbellay", postOffice))).start();
        (new Thread(new Customer("Mrs Müller", postOffice))).start();
    }
}
