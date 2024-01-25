package JLivelockCouple;

// Déclaration de la classe Spoon
class Spoon {
    // Variable pour stocker le propriétaire actuel de la cuillère
    private Diner owner;

    // Méthode pour obtenir le propriétaire actuel de la cuillère
    public Diner getOwner() {
        return owner;
    }

    // Constructeur de la classe, prenant un convive comme propriétaire initial
    public Spoon(Diner d) {
        owner = d;
    }

    // Méthode synchronisée pour définir le propriétaire de la cuillère
    public synchronized void setOwner(Diner d) {
        owner = d;
    }

    // Méthode synchronisée pour simuler l'utilisation de la cuillère
    public synchronized void use() {
        System.out.printf("%s has eaten!", owner.getName());
    }
}
