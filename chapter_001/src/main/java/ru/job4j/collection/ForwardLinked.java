package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
    }

    public T deleteLast() {
        Node<T> tail = head;
        while (tail.next != null) {
            if (tail.next.next == null) {
                T rsl = tail.next.value;
                tail.next = null;
                return rsl;
            }
            tail = tail.next;
        }
        T rsl = head.value;
        head = null;
        return rsl;
    }

    public void revert() {
        Node<T> prevNode = null;
        Node<T> node = head;
        Node<T> nextNode = head.next;
        while (nextNode != null) {
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
            nextNode = node.next;
        }
        node.next = prevNode;
        head = node;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}