package NReentrantReradWriteLock;

import java.time.LocalDateTime;

// Déclaration de la classe News
public class News {
    // Variables pour stocker le texte de la nouvelle et sa date de création
    private String news;
    private LocalDateTime date;

    // Constructeur de la classe, prenant le texte de la nouvelle en tant que paramètre
    public News(String news) {
        // Initialisation du texte de la nouvelle
        this.news = news;
        // Initialisation de la date de création avec la date et l'heure actuelles
        this.date = LocalDateTime.now();
    }

    // Méthode toString pour obtenir une représentation textuelle de l'objet News
    @Override
    public String toString() {
        return "News{" +
                "news='" + news + '\'' +
                ", date=" + date +
                '}';
    }
}
