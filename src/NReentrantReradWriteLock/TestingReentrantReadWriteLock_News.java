package NReentrantReradWriteLock;

// Déclaration de la classe TestingReentrantReadWriteLock_News
public class TestingReentrantReadWriteLock_News {
    public static void main(String[] args) {
        // Création d'un objet NewsFeed
        NewsFeed newsFeed = new NewsFeed();

        // Ajout d'une première actualité pour démarrer le flux d'actualités
        newsFeed.put(new News("START OF NEWS"));

        // Création d'un thread d'écriture
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Ajout de plusieurs actualités dans le flux
                for (int i = 0; i < 200; i++) {
                    newsFeed.put(new News("News " + i));
                }
            }
        }).start();

        // Création de plusieurs threads de lecture
        for (int i = 0; i < 20; i++) {
            new Thread((new Runnable() {
                @Override
                public void run() {
                    // Lecture de plusieurs actualités du flux
                    for (int i = 0; i < 20; i++) {
                        // Lecture d'une actualité
                        News news = newsFeed.read();
                        // Affichage de l'actualité lue
                        if (news != null) {
                            System.out.println("News read : " + news);
                        }
                    }
                }
            })).start();
        }
    }
}
