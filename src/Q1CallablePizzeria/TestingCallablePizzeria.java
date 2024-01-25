package Q1CallablePizzeria;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Classe de test pour l'utilisation de Callable et Future avec des pizzaiolos
public class TestingCallablePizzeria {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Création de deux instances de PizzaioloCallable pour préparer des pizzas.
        PizzaioloCallable marco = new PizzaioloCallable("Marco");
        PizzaioloCallable antonio = new PizzaioloCallable("Antonio");

        // Création d'un exécuteur avec un pool de 2 threads et soumission des deux tâches.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Tant que la pizzeria est ouverte
        while (true) {
            // Soumission des tâches aux pizzaiolos Marco et Antonio, obtenir les objets Future pour récupérer les résultats plus tard.
            Future<Pizza> pizzaOrderToMarco = executor.submit(marco);
            Future<Pizza> pizzaOrderToAntonio = executor.submit(antonio);

            // Affichage des résultats une fois que les pizzas sont prêtes
            System.out.println("Marco's pizza is ready: pizza " + pizzaOrderToMarco.get().hashCode());
            System.out.println("Antonio's pizza is ready: pizza " + pizzaOrderToAntonio.get().hashCode());
        }
    }
}
