package org.example.MyLinkedList;

import java.util.Iterator;

public class LinkedListIterator <E> implements Iterator<E> {
    int index;
    OneWayLinkedList<E> o;

    public LinkedListIterator(OneWayLinkedList<E> o) {
        this.index = 0;
        this.o = o;
    }

    @Override
    public boolean hasNext() {
        return index < o.size();
    }

    @Override
    public E next() {
        return o.get(index++);
    }
}
