package NReentrantReradWriteLock;

import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Déclaration de la classe NewsFeed
public class NewsFeed {
    // Pile d'actualités
    private Stack<News> newsFeed = new Stack<News>();

    // Verrou de lecture-écriture pour gérer l'accès concurrentiel
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // Verrou d'écriture
    private Lock writeLock = lock.writeLock();

    // Verrou de lecture
    private Lock readLock = lock.readLock();

    // Méthode pour ajouter une nouvelle au flux d'actualités
    public void put(News news) {
        try {
            // Acquisition du verrou d'écriture
            writeLock.lock();
            // Ajout de la nouvelle à la pile d'actualités
            newsFeed.push(news);
        } finally {
            // Libération du verrou d'écriture dans le bloc finally pour garantir la libération même en cas d'exception
            writeLock.unlock();
        }
    }

    // Méthode pour lire la dernière nouvelle du flux d'actualités
    public News read() {
        News news;
        try {
            // Acquisition du verrou de lecture
            readLock.lock();
            // Lecture de la dernière nouvelle sans la retirer de la pile
            news = newsFeed.peek();
        } finally {
            // Libération du verrou de lecture dans le bloc finally pour garantir la libération même en cas d'exception
            readLock.unlock();
        }
        return news;
    }
}
