package JLivelockCouple;

// Déclaration de la classe Diner
class Diner {
    // Variables pour stocker le nom du convive et son état de faim
    private String name;
    private boolean isHungry;

    // Constructeur de la classe, prenant le nom du convive en tant que paramètre
    public Diner(String name) {
        this.name = name;
        isHungry = true;
    }

    // Méthode pour obtenir le nom du convive
    public String getName() {
        return name;
    }

    // Méthode pour vérifier si le convive a faim
    public boolean isHungry() {
        return isHungry;
    }

    // Méthode pour simuler le repas avec une cuillère et un conjoint
    public void eatWith(Spoon spoon, Diner spouse) {
        // Boucle tant que le convive est affamé
        while (isHungry) {
            // Si le convive n'a pas la cuillère, attend patiemment que le conjoint la passe
            if (spoon.getOwner() != this) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    continue;
                }
                continue;
            }

            // Si le conjoint a faim, insiste pour lui passer la cuillère
            if (spouse.isHungry()) {
                System.out.printf(
                        "%s: You eat first my darling %s!%n",
                        name, spouse.getName());
                spoon.setOwner(spouse);
                continue;
            }

            // Si le conjoint n'a pas faim, mange enfin
            spoon.use();
            isHungry = false;
            System.out.printf(
                    "%s: I am stuffed, my darling %s!%n",
                    name, spouse.getName());
            spoon.setOwner(spouse);
        }
    }
}
