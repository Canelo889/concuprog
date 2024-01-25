package OReentrantWithConditions;


import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
// Déclaration de la classe LockedWithConditionsStack
public class LockedWithConditionsStack {
    // Pile pour stocker les éléments
    private Stack<Integer> stack = new Stack<Integer>();

    // Capacité maximale de la pile
    private int CAPACITY = 5;

    // Verrou réentrant pour assurer l'accès exclusif à la pile
    ReentrantLock lock = new ReentrantLock();

    // Condition pour signaler que la pile est vide
    Condition stackEmptyCondition = lock.newCondition();

    // Condition pour signaler que la pile est pleine
    Condition stackFullCondition = lock.newCondition();

    // Constructeur prenant la capacité maximale en tant que paramètre
    public LockedWithConditionsStack(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    // Méthode pour pousser un élément sur la pile
    public void pushToStack(Integer item) {
        try {
            // Acquérir le verrou
            lock.lock();

            // Attendre tant que la pile est pleine
            while (stack.size() == CAPACITY) {
                stackFullCondition.await();
            }

            // Pousser l'élément sur la pile
            stack.push(item);

            // Signaler que la pile n'est plus vide
            stackEmptyCondition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // Libérer le verrou dans tous les cas (même en cas d'exception)
            lock.unlock();
        }
    }

    // Méthode pour retirer un élément de la pile
    public Integer popFromStack() {
        try {
            // Acquérir le verrou
            lock.lock();

            // Attendre tant que la pile est vide
            while (stack.size() == 0) {
                stackEmptyCondition.await();
            }

            // Retirer et renvoyer l'élément de la pile
            return stack.pop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // Signaler que la pile n'est plus pleine
            stackFullCondition.signalAll();

            // Libérer le verrou dans tous les cas (même en cas d'exception)
            lock.unlock();
        }
    }
}
