package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int modCount = 0;
    private int size;
    private final int defCapacity = 10;

    public SimpleArray() {
        container = new Object[]{};
    }

    public SimpleArray(int size) {
        container = new Object[size];
        this.size = size;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (container.length == 0) {
            container = new Object[defCapacity];
        } else if (size == container.length) {
            incSize(container.length * 2);
        }
        container[size++] = model;
        modCount++;
    }

    public void incSize(int newCapacity) {
        container = Arrays.copyOf(container, newCapacity);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return position < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[position++];
            }
        };
    }
}
