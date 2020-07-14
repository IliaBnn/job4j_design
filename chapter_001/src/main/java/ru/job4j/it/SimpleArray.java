package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int position = 0;

    public SimpleArray(int size) {
        objects = new Object[size];
    }

    public void add(T model) {
        objects[position++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, position);
        objects[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, position);
        System.arraycopy(objects, index + 1, objects, index, position - index - 1);
        objects[position - 1] = null;
        position--;
    }

    public T get(int index) {
        Objects.checkIndex(index, position);
        return (T) objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[index++];
            }
        };
    }
}
