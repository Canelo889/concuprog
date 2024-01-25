package Q3ParallelSort;

public class Author implements Comparable<Author> {

    // Attributs représentant le prénom et le nom de l'auteur
    private String firstname;
    private String lastname;

    // Constructeur pour initialiser un objet Author avec un prénom et un nom
    public Author(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Méthode de comparaison pour l'interface Comparable
    @Override
    public int compareTo(Author o) {
        // Compare les prénoms des auteurs
        int firstnameComparisonResult = this.getFirstname().compareTo(o.getFirstname());

        // Si les prénoms sont différents, retourne le résultat de la comparaison des prénoms
        if (firstnameComparisonResult != 0) {
            return firstnameComparisonResult;
        }

        // Si les prénoms sont identiques, compare les noms des auteurs
        return this.getLastname().compareTo(o.getLastname());
    }

    // Méthode getter pour obtenir le prénom de l'auteur
    public String getFirstname() {
        return firstname;
    }

    // Méthode getter pour obtenir le nom de l'auteur
    public String getLastname() {
        return lastname;
    }
}
