package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleList<T> implements Iterable<T> {
    private int size;
    private Node<T> head;
    private Node<T> last;
    private int modCount;

    public void add(T model) {
        Node<T> newNode;
        if (size == 0) {
            newNode = new Node<>(null, model, null);
            head = newNode;
        } else {
            newNode = new Node<>(last, model, null);
            last.next = newNode;
        }
        last = newNode;
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> search;
        if (index > size / 2) {
            index = size - index - 1;
            search = last;
            while (index > 0) {
                search = search.prev;
                index--;
            }
        } else {
            search = head;
            while (index > 0) {
                search = search.next;
                index--;
            }
        }
        return search.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int expectedModCount = modCount;
            private Node<T> position = head;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (index == 0) {
                    index++;
                    return position.value;
                }
                position = position.next;
                index++;
                return position.value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
