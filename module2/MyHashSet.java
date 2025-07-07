import java.util.Arrays;

public class MyHashSet<T> {
  private static final int DEFAULT_CAPACITY = 16;
  private T[] array;
  int size;

  @SuppressWarnings("unchecked")
  public MyHashSet() {
    array = (T[]) new Object[DEFAULT_CAPACITY];
    size = 0;
  }

  // Добавление элемента
  public void add(T element) {
    if (contains(element)) {
      return;
    }
    ensureCapacity();
    array[size] = element;
    size++;
  }

  // Удаление элемента
  public boolean remove(T element) {
    for (int i = 0; i < size; i++) {
      if (element == null ? array[i] == null : element.equals(array[i])) {
        System.arraycopy(array, i + 1, array, i, size - i - 1);
        array[--size] = null;
        return true;
      }
    }
    return false;
  }

  // Проверка наличия элемента
  public boolean contains(T element) {
    for (int i = 0; i < size; i++) {
        if (element == null) {
            if (array[i] == null) {
                return true;
            }
        } else {
            if (element.equals(array[i])) {
                return true;
            }
        }
    }
    return false;
}

  // Увеличение вместимости
  private void ensureCapacity() {
    if (size == array.length) {
      array = Arrays.copyOf(array, array.length * 2);
    }
  }

  public int size() {
    return size;
  }
}
