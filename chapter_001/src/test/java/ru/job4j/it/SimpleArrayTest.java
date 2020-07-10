package ru.job4j.it;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test
    public void whenGetThenTrue() {
        SimpleArray<Integer> sa = new SimpleArray<>(4);
        sa.add(4);
        sa.add(3);
        assertThat(sa.get(0), is(4));
        assertThat(sa.get(1), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddThenFalse() {
        SimpleArray<Integer> sa = new SimpleArray<>(2);
        sa.add(1);
        sa.add(2);
        sa.add(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetThenFalse() {
        SimpleArray<Integer> sa = new SimpleArray<>(2);
        sa.add(1);
        sa.get(1);
    }

    @Test
    public void whenSetThenTrue() {
        SimpleArray<Integer> sa = new SimpleArray<>(2);
        sa.add(0);
        sa.add(1);
        sa.set(1, 5);
        assertThat(sa.get(1), is(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetThenFalse() {
        SimpleArray<Integer> sa = new SimpleArray<>(2);
        sa.set(1, 6);
    }

    @Test
    public void whenRemoveThenTrue() {
        SimpleArray<Integer> sa = new SimpleArray<>(4);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.add(4);
        assertThat(sa.get(1), is(2));
        sa.remove(1);
        assertThat(sa.get(1), is(3));
        assertThat(sa.get(2), is(4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveTheLastElementDelete() {
        SimpleArray<Integer> sa = new SimpleArray<>(4);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.add(4);
        sa.remove(1);
        sa.get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveThenFalse() {
        SimpleArray<String> sa = new SimpleArray<>(4);
        sa.add("a");
        sa.add("b");
        sa.add("c");
        sa.remove(3);
    }

    @Test
    public void whenIterate() {
        SimpleArray<Integer> sa = new SimpleArray<>(4);
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.add(4);
        Iterator<Integer> it = sa.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorDoesntHasNext() {
        SimpleArray<Integer> sa = new SimpleArray<>(3);
        sa.add(1);
        sa.add(2);
        Iterator<Integer> it = sa.iterator();
        it.next();
        it.next();
        it.next();
    }
}