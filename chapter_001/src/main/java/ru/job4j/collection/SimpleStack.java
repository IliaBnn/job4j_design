package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    public T pop() {
        T rsl = linked.getLast();
        linked.deleteLast();
        return rsl;
    }

    public void push(T value) {
        linked.add(value);
    }

    public boolean isEmpty() {
        return linked.isEmpty();
    }
}
