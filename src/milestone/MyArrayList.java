package milestone;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void add(T item) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = item;
    }

    @Override
    public void set(T item) {
        add(item);
    }

    @Override
    public void set(T item, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        elements[index] = item;
    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == elements.length) {
            resize();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(item, 0);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) elements[size - 1];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        // Implement sorting algorithm, such as quicksort or mergesort
        // For simplicity, we'll omit it here.
    }

    @Override
    public int index0f(Object object) {
        return 0;
    }

    @Override
    public int lastIndex0f(Object object) {
        return 0;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return (T) elements[currentIndex++];
            }
        };
    }
}
