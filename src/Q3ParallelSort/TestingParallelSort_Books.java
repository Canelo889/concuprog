package Q3ParallelSort;

/* @author Yvan Pannatier */
    
import java.util.Arrays;

public class TestingParallelSort_Books {

    private static int DATASET_SIZE = 10000000;

    public static void main(String[] args) {

        // Here we generate a dataset of 10 million of books  and we then deep copy it.
        // It is to ensure that both sort and parallelSort have the same array to sort.
        Book[] booksToSequentialSort = new Book[DATASET_SIZE];
        for(int i = 0; i < booksToSequentialSort.length; i++) {
            booksToSequentialSort[i] = RandomGenerator.generateBook();
        }
        Book[] booksToParallelSort = Arrays.copyOf(booksToSequentialSort, booksToSequentialSort.length);

        // Print 10 first books of each dataset to ensure that it is not sorted
        System.out.println("\n\n10 first books from booksToSequentialSort library");
        System.out.println("===================================================");
        displayTenFirstBook(booksToSequentialSort);

        System.out.println("\n\n10 first books from booksToParallelSort library");
        System.out.println("===================================================");
        displayTenFirstBook(booksToParallelSort);

        // Using sequential sort
        long startNormalSort = System.currentTimeMillis();
        Arrays.sort(booksToSequentialSort);
        long normalSortTime = System.currentTimeMillis() - startNormalSort;


        // Using parallel sort
        long startParallelSort = System.currentTimeMillis();
        Arrays.parallelSort(booksToParallelSort);
        long parallelSortTime = System.currentTimeMillis() - startParallelSort;


        // display 10 first books of each dataset to ensure they are sorted
        System.out.println("\n\n10 first books from booksToSequentialSort library after sorting");
        System.out.println("===================================================");



        displayTenFirstBook(booksToSequentialSort);
        System.out.println("\n\n10 first books from booksToParallelSort library after sorting");
        System.out.println("===================================================");
        displayTenFirstBook(booksToParallelSort);


        // Display the duration of both sorts.
        System.out.println("\n\nSorting Time");
        System.out.println("===================================================");
        System.out.println("Normal Sort: " + normalSortTime + "ms");
        System.out.println("Parallel Sort: " + parallelSortTime + "ms");
    }



    private static void displayTenFirstBook(Book[] list) {
        for(int i = 0; i < 10; i++) {
            System.out.println(list[i].toString());
        }
    }
}
