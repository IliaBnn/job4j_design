package ru.job4j.collection;


import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size;

    public T poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < size - 1; i++) {
            out.push(in.pop());
        }
        T rsl = in.pop();
        size--;
        for (int i = 0; i < size; i++) {
            in.push(out.pop());
        }
        return rsl;
    }

    public void push(T value) {
        in.push(value);
        size++;
    }

    public boolean isEmpty() {
        return in.isEmpty();
    }
}
