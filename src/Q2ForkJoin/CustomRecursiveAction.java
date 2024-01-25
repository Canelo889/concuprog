package Q2ForkJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

// Une tâche récursive sans retour de résultat
public class CustomRecursiveAction extends RecursiveAction {
    private String workload = "";  // La charge de travail associée à cette tâche
    private static final int THRESHOLD = 10;  // Seuil pour déterminer si la tâche doit être subdivisée
    private static Logger logger = Logger.getAnonymousLogger();  // Utilisation d'un logger pour les messages

    // Constructeur
    public CustomRecursiveAction(String workload) {
        this.workload = workload;
    }

    // Méthode principale pour exécuter la tâche
    @Override
    protected void compute() {
        // Vérifie si la charge de travail est suffisamment grande pour être subdivisée
        if (workload.length() > THRESHOLD)
            ForkJoinTask.invokeAll(createSubtasks());  // Subdivise la tâche en créant des sous-tâches
        else
            processing(workload);  // Si la charge de travail est petite, effectue le traitement directement
    }

    // Crée des sous-tâches en divisant la charge de travail
    private List<CustomRecursiveAction> createSubtasks() {
        List<CustomRecursiveAction> subtasks = new ArrayList<>();

        // Divise la charge de travail en deux parties
        String partOne = workload.substring(0, workload.length() / 2);
        String partTwo = workload.substring(workload.length() / 2, workload.length());

        // Crée deux sous-tâches avec les parties divisées de la charge de travail
        subtasks.add(new CustomRecursiveAction(partOne));
        subtasks.add(new CustomRecursiveAction(partTwo));

        return subtasks;
    }

    // Effectue le traitement sur la charge de travail
    private void processing(String work) {
        String result = work.toUpperCase();
        // Affiche un message indiquant le résultat du traitement et le thread qui l'a traité
        logger.info("This result - (" + result + ") - was processed by "
                + Thread.currentThread().getName());
    }
}
