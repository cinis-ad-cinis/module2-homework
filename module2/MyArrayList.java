import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MyArrayList<T> implements Iterable<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private int count = 0;
  private T[] array;

  @SuppressWarnings("unchecked")
  public MyArrayList() {
    array = (T[]) new Object[DEFAULT_CAPACITY];
  }

  // Добавление элемента в конец
  public void add(T element) {
    ensureCapacity();
    array[count++] = element;
  }

  public Stream<T> stream() {
      return Arrays.stream(array, 0, count);
    }

  // Добавление по индексу
  public void add(T element, int index) {
    checkIndexForAdd(index);
    ensureCapacity();
    for (int i = count; i > index ; i--) {
      array[i] = array[i - 1];
    }
    array[index] = element;
    count++;
  }

    public T get(int index) {
      checkIndex(index);
      return array[index];
    }

  // Расширение вместимости
    private void ensureCapacity() {
      if (count == array.length) {
        int newCapacity = array.length + (array.length >> 1);
        array = Arrays.copyOf(array, newCapacity);
      }
    }

    private void checkIndex(int index) {
      if (index >= count || index < 0) {
        throw new IndexOutOfBoundsException("Index " + index + ", Size " + count);
      }
    }

    private void checkIndexForAdd(int index) {
      if (index > count || index < 0) {
      throw new IndexOutOfBoundsException("Index " + index + ", Size " + count);
    }
  }

    public int size() {
      return count;
    }
    
    public int capacity() {
      return array.length;
    }

    @Override
    public Iterator<T> iterator() {
      return new Iterator<T>() {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
          return currentIndex < count;
        }

        @Override
        public T next() {
          return array[currentIndex++];
        }
      };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < count; i++) {
          action.accept(array[i]);
        }
    }

    @Override
    public Spliterator<T> spliterator() {
      return Iterable.super.spliterator();
    }
}
