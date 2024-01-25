package Q3ParallelSort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Helper class to randomly generate a book.
 * It contains a generation function for each fields of the book.
 */
public class RandomGenerator {

    // 50 firstnames for random book generation
    private static List<String> FIRSTNAMES = Arrays.asList("James", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Charles", "Thomas",
            "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Kenneth", "Joshua", "George", "Kevin", "Brian",
            "Edward", "Ronald", "Timothy", "Jason", "Jeffrey", "Ryan", "Jacob", "Gary", "Nicholas", "Eric", "Stephen", "Jonathan", "Larry", "Justin",
            "Scott", "Frank", "Brandon", "Raymond", "Gregory", "Benjamin", "Samuel", "Patrick", "Alexander", "Jack", "Dennis", "Jerry", "Tyler", "Aaron",
            "Jose", "Henry", "Douglas", "Adam", "Peter", "Nathan", "Zachary", "Walter");

    // 50 lastname for random book generation
    private static List<String> LASTNAMES = Arrays.asList("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell");

    // 25 isbn for random book generation
    private static List<Long> ISBNs = Arrays.asList(9780316769487L, 9780446310789L, 9780743273565L, 9780451524935L, 9780544003415L, 9780553213584L, 9780394800165L, 9781594631931L, 9780307887443L, 9780547928227L, 9780141187761L, 9781501167565L, 9780743247542L, 9780689835605L, 9780307474278L, 9788401014996L, 9780679890478L, 9780857533830L, 9780439023528L, 9780517123201L, 9780060850524L, 9780399171624L, 9780684801223L, 9780385034067L, 9780451205360L, 9780060791745L, 9780312367541L);

    // 25 book titles for random book generation
    private static List<String> BOOK_TITLES = Arrays.asList("The Catcher in the Rye", "To Kill a Mockingbird", "The Great Gatsby", "Nineteen Eighty-Four", "The Lord of the Rings", "The Grapes of Wrath", "Pride and Prejudice", "The Kite Runner", "The Hunger Games", "The Hobbit", "Animal Farm", "The fault in our stars", "The Glass Castle", "The Book Thief", "The Chronicles of Narnia", "The Da Vinci Code", "The Alchemist", "The Cat in the Hat", "The Little Prince", "The Chronicles of Narnia", "The Harry Potter Series", "The Bible", "The Sun Also Rises", "The Lord of the Flies", "The Old Man and the Sea", "The Outsiders");

    private static final Random random = new Random();

    private static Author generateAuthor() {

        int idx = random.nextInt(FIRSTNAMES.size());
        String firstname = FIRSTNAMES.get(idx);

        idx = random.nextInt(LASTNAMES.size());
        String lastname = LASTNAMES.get(idx);
        Author author = new Author(firstname, lastname);
        return author;
    }

    private static long generateISBN() {
        int idx = random.nextInt(ISBNs.size());
        long isbn = ISBNs.get(idx);
        return  isbn;
    }

    // Select a random year between 1900 and 2023
    private static int generateYear() {
        int year = random.nextInt(124) + 1900;
        return year;
    }

    private static String generateTitle() {
        int idx = random.nextInt(BOOK_TITLES.size());
        String title = BOOK_TITLES.get(idx);
        return title;
    }

    public static Book generateBook() {
        return new Book(generateISBN(), generateAuthor(), generateYear(), generateTitle());
    }
}
