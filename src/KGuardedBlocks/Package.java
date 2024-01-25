package KGuardedBlocks;

// Déclaration de la classe Package
public class Package {
    // Variable pour stocker le client expéditeur du colis
    private Customer sender;

    // Constructeur de la classe, prenant le client expéditeur en tant que paramètre
    public Package(Customer sender) {
        this.sender = sender;
    }

    // Méthode toString() pour obtenir une représentation textuelle du colis
    @Override
    public String toString() {
        return "Package{" +
                "sender=" + sender.getName() +
                '}';
    }
}
