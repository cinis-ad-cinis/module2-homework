public class Main {
  public static void main(String[] args) {
    MyArrayList<Student> students = new MyArrayList<>();

    Student anna = new Student("Анна");
    anna.addBook(new Book("Java: Основы", "Кей Хорстман", 2019, 864));
    anna.addBook(new Book("Чистый код", "Роберт Мартин", 2008, 464));
    anna.addBook(new Book("Алгоритмы", "Роберт Седжвик", 2011, 976));
    anna.addBook(new Book("Философия Java", "Брюс Эккель", 2017, 1168));
    anna.addBook(new Book("Паттерны проектирования", "Эрих Гамма", 2020, 512));
    students.add(anna);

    Student ivan = new Student("Иван");
    ivan.addBook(new Book("Совершенный код", "Стив Макконнелл", 2010, 896));
    ivan.addBook(new Book("Рефакторинг", "Мартин Фаулер", 2018, 448));
    ivan.addBook(new Book("Программист-прагматик", "Эндрю Хант", 2019, 352));
    ivan.addBook(new Book("Грокаем алгоритмы", "Адитья Бхаргава", 2017, 288));
    ivan.addBook(new Book("JavaScript: Сильные стороны", "Дуглас Крокфорд", 2021, 176));
    students.add(ivan);

    Student alexey = new Student("Алексей");
    alexey.addBook(new Book("1984", "Джордж Оруэлл", 1949, 328));
    alexey.addBook(new Book("О дивный новый мир", "Олдос Хаксли", 1932, 288));
    alexey.addBook(new Book("Мы", "Евгений Замятин", 1924, 320));
    alexey.addBook(new Book("451° по Фаренгейту", "Рэй Брэдбери", 1953, 256));
    alexey.addBook(new Book("Скотный двор", "Джордж Оруэлл", 1945, 176));
    students.add(alexey);

    Student maria = new Student("Мария");
    maria.addBook(new Book("Идеальный программист", "Роберт Мартин", 2011, 224));
    maria.addBook(new Book("Порождающие шаблоны", "Эрих Гамма", 2022, 384));
    maria.addBook(new Book("Head First Java", "Кэти Сьерра", 2022, 720));
    maria.addBook(new Book("Искусство программирования", "Дональд Кнут", 2015, 896));
    maria.addBook(new Book("Теоретический минимум", "Владстон Феррейра", 2019, 320));
    students.add(maria);


    students.stream()
      .peek(System.out::println)
      .flatMap(student -> student.getBooks().stream())
      .sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
      .distinct()
      .filter(book -> book.getYear() > 2000)
      .limit(3)
      .map(Book::getYear)
      .findFirst()
      .ifPresentOrElse(
          year -> System.out.println("\nРезультат: Год выпуска - " + year),
          () -> System.out.println("\nРезультат: Книга не найдена")
      );
  }
}