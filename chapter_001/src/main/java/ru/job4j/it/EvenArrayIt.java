package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int index = 0;

    public EvenArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length && !isEven(data[index])) {
            index++;
        }
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    public boolean isEven(int value) {
        return value % 2 == 0;
    }
}
