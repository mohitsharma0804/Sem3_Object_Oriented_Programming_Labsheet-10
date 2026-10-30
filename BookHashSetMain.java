import java.util.HashSet;
import java.util.Objects;

class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void displayDetails() {
        System.out.println("Book [ID: " + id + ", Title: "" + title + "", Author: " + author + "]");
    }

    // Override equals and hashCode based on 'id' to avoid duplicates in HashSet
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class BookHashSetMain {
    public static void main(String[] args) {
        HashSet<Book> bookSet = new HashSet<>();

        Book b1 = new Book(101, "Java Programming", "James Gosling");
        Book b2 = new Book(102, "Data Structures in Java", "Robert Lafore");
        Book b3 = new Book(101, "Duplicate Java Book", "Unknown"); // Duplicate ID (101)

        System.out.println("Adding Book 1 (ID 101): " + bookSet.add(b1));
        System.out.println("Adding Book 2 (ID 102): " + bookSet.add(b2));
        System.out.println("Adding Book 3 (ID 101 - Duplicate ID): " + bookSet.add(b3));

        System.out.println("
=== Books Stored in HashSet (Duplicates Ignored) ===");
        for (Book b : bookSet) {
            b.displayDetails();
        }
    }
}
