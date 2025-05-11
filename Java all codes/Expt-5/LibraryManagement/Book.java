package LibraryManagement;

public class Book {
    public String title, author, isbn;

    public Book(String t, String a, String i) {
        title = t;
        author = a;
        isbn = i;
    }

    public void display() {
        System.out.println("Book: " + title + ", " + author + ", " + isbn);
    }
}
