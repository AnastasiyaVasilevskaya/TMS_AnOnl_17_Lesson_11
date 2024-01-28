package mycollection;

import java.util.Arrays;


public class ListArray<E> implements ListCollection<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] ar;

    public ListArray() {
        this(DEFAULT_CAPACITY);
    }

    public ListArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        this.ar = new Object[initialCapacity];
        this.size = 0;
    }

    @Override
    public void add(E e) {
        ensureCapacity();
        ar[size] = e;
        size++;
    }

    private void ensureCapacity() {
        if (size == ar.length) {
            int newAr = ar.length * 2;
            ar = Arrays.copyOf(ar, newAr);
        }
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                ar[i] = ar[i + 1];
            }
        }
        size--;
    }

    @Override
    //удаление элемента по его значению
    public void remove(E e) {
        int index;
        while ((index = indexOf(e)) != -1) {
            remove(index);
        }
    }

    private int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(ar[i])) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    @Override
    public E elementByIndex(int index) {
        if (index >= 0 && index < size) {
            return (E) ar[index];
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(ar[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        ar = new Object[DEFAULT_CAPACITY];
        int size = 0;
    }

    public void printElements() {
        for (int i = 0; i < size; i++) {
            System.out.println(ar[i]);
        }
        System.out.println();
    }
}
