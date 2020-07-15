package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleListTest {

    @Test
    public void whenAddThenGet() {
        SimpleList<Integer> sl = new SimpleList<>();
        sl.add(5);
        sl.add(6);
        sl.add(8);
        assertThat(sl.get(0), is(5));
        assertThat(sl.get(1), is(6));
        assertThat(sl.get(2), is(8));
    }

    @Test
    public void whenAddThenIt() {
        SimpleList<Integer> sl = new SimpleList<>();
        sl.add(5);
        sl.add(6);
        sl.add(8);
        Iterator<Integer> it = sl.iterator();
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(8));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromEmpty() {
        SimpleList<Integer> sl = new SimpleList<>();
        sl.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutOfBound() {
        SimpleList<Integer> sl = new SimpleList<>();
        sl.add(2);
        sl.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleList<String> sl = new SimpleList<>();
        sl.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleList<String> sl = new SimpleList<>();
        sl.add("first");
        Iterator<String> it = sl.iterator();
        sl.add("second");
        it.next();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void whenHasntNext() {
        SimpleList<String> sl = new SimpleList<>();
        sl.add("first");
        sl.add("second");
        Iterator<String> it = sl.iterator();
        it.next();
        it.next();
        it.next();
    }

}