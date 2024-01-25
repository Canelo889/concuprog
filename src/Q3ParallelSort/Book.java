package Q3ParallelSort;

public class Book implements Comparable<Book> {

    // Attributs représentant les caractéristiques d'un livre
    private long isbn;
    private Author author;
    private int year;
    private String title;

    // Constructeur pour initialiser un objet Book avec ISBN, auteur, année et titre
    public Book(long isbn, Author author, int year, String title) {
        this.isbn = isbn;
        this.author = author;
        this.year = year;
        this.title = title;
    }

    // Méthode de comparaison pour l'interface Comparable
    @Override
    public int compareTo(Book o) {
        // Compare les titres des livres
        int titleComparisonResult = this.getTitle().compareTo(o.getTitle());
        if (titleComparisonResult != 0) {
            return titleComparisonResult;
        }

        // Compare les auteurs des livres
        int authorComparisonResult = this.getAuthor().compareTo(o.getAuthor());
        if (authorComparisonResult != 0) {
            return authorComparisonResult;
        }

        // Compare les années de publication des livres
        int yearComparisonResult = this.getYear() - o.getYear();
        if (yearComparisonResult != 0) {
            return yearComparisonResult;
        }

        // Compare les ISBN des livres
        long isbnComparisonResult = this.getIsbn() - o.getIsbn();
        if (isbnComparisonResult != 0) {
            return isbnComparisonResult < 0 ? -1 : 1;
        }
        return 0; // Les livres sont considérés comme égaux s'ils ont les mêmes attributs
    }

    // Méthodes getter pour obtenir les caractéristiques d'un livre
    public long getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    // Méthode toString pour afficher les informations d'un livre
    @Override
    public String toString() {
        return title + " from " + author.getFirstname() + " " + author.getLastname()
                + " published in " + year + " with ISBN: " + isbn;
    }
}
