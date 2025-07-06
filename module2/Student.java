import java.util.ArrayList;
import java.util.List;

public class Student {
  private final String name;
  private final List<Book> books = new ArrayList<>();

  public Student(String name) {
    this.name = name;
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public List<Book> getBooks() {
    return new ArrayList<>(books);
  }

  @Override
  public String toString() {
    return "Студент: " + name + "\nКниги: " + books;
  }
}