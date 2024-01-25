package Q1CallablePizzeria;

import java.util.concurrent.Callable;

// Classe PizzaioloCallable implémentant l'interface Callable
public class PizzaioloCallable implements Callable<Pizza> {
    // Nom du pizzaiolo
    private String name;

    // Constructeur prenant le nom du pizzaiolo en tant que paramètre
    public PizzaioloCallable(String name) {
        this.name = name;
    }

    // Méthode call() qui est exécutée lorsqu'un thread est démarré pour le Callable
    @Override
    public Pizza call() throws Exception {
        // Affichage du démarrage du thread du pizzaiolo
        System.out.println("Thread " + name + " started by the executor");

        // Simulation d'une pause aléatoire pendant la préparation de la pizza
        Thread.sleep((long) Math.random() * 1000);

        // Création d'une instance de Pizza
        Pizza pizza = new Pizza();

        // Appel des méthodes pour préparer, cuire et couper la pizza
        pizza.prepare();
        pizza.bake();
        pizza.cut();

        // Affichage de la fin de la préparation de la pizza par le pizzaiolo
        System.out.println("Thread " + name + " pizza finished.");

        // Retour de l'instance de Pizza résultante
        return pizza;
    }
}
