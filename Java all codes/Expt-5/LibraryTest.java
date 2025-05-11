import LibraryManagement.*;

public class LibraryTest {
    public static void main(String[] args) {
        Book b = new Book("Java", "James", "12345");
        Member m = new Member("Alice", 1);
        b.display();
        m.display();
    }
}
