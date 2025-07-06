import java.util.Objects;

public class Book {
  private String title;
  private String author;
  private int year;
  private int pages;

  public Book(String title, String author, int year, int pages) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.pages = pages;
  }

    public int getYear() {
      return year;
    }

    public int getPages() {
      return pages;
    }

  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    };
    if (obj == null) {
      return false;
    }
    if (obj instanceof Book) {
      Book book = (Book) obj;

      return year == book.year && pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
    else {
      return false;
    }
  }

  @Override
  public String toString() {
    return title + " (" + author + ", " + year + ")";
  }
}
