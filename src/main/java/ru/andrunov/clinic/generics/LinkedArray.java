package ru.andrunov.clinic.generics;

import java.util.Iterator;

/**
 * collection of elements
 * builds by connecting innerclasses
 */
public class LinkedArray<T> implements Iterable<T> {
    private int size;
    private Element<T> first;
    private Element<T> last;

    public LinkedArray() {
    }

    public int size() {
        return size;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Element<T> x = first; x != null; ) {
            Element<T> next = x.next;
            x.value = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * check that send index is valid
     * @param index - index to check
     */
    private void checkIndex(int index){
        if (index < 0 || index > this.size){
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d",index,this.size));
        }
    }

    // Positional Access Operations

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public T get(int index) {
        checkIndex(index);
        return element(index).value;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public void set(int index, T element) {
        checkIndex(index);
        element(index).value = element;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param t value to be added
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public void add(int index, T t) {
        checkIndex(index);
        final Element<T> nextElement = element(index);
        final Element<T> prevElement = nextElement.prev;
        final Element<T> newNode = new Element<T>(prevElement, t, nextElement);
        nextElement.prev = newNode;
        if (prevElement == null)
            first = newNode;
        else
            prevElement.next = newNode;
        size++;
    }


    /**
     * add new element to the end of the list
     * @param t - element to add
     */
    public void add(T t){
        final Element<T> l = last;
        final Element<T> newElement = new Element<T>(l, t ,null);
        last = newElement;
        if (l == null)
            first = newElement;
        else
            l.next = newElement;
        size++;
    }

    /**
     * removes element from list
     * @param index - position from element to remove
     */
    public void remove(int index){
        checkIndex(index);
        Element<T> element = element(index);
        final T value = element.value;
        final Element<T> next = element.next;
        final Element<T> prev = element.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            element.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            element.next = null;
        }

        element.value = null;
        size--;

    }

    /**
     * removes element from list
     * @param t - element to remove
     */
    public void remove(T t){
        if (indexOf(t) != -1){
            remove(indexOf(t));
        }
    }

    /**
     * check that collection contains
     * element with such object
     * @param t - object to check
     * @return true if contents
     */
    public boolean contains(T t){
        boolean result = false;
        for (T obj : this){
            result = obj.equals(t);
            if (result) break;
        }
        return result;
    }

    /**
     * returns index of object
     * or -1 if collection dos not consist
     * @param t - object to find index
     * @return - index of object
     */
    public int indexOf(T t){
        int result = -1;
        int index = 0;
        for (T obj : this){
            if (obj.equals(t)){
                result = index;
                break;
            }
            index++;
        }
        return result;
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    private Element<T> element(int index) {
        // assert isElementIndex(index);
        Element<T> result = null;
        if (index < (size / 2)) {
            result = first;
            for (int i = 0; i < index; i++)
                result = result.next;
        } else {
            result = last;
            for (int i = size - 1; i > index; i--)
                result = result.prev;
        }
        return result;
    }

    /**
     * inner class provides pieces
     * for elements to adds
     * @param <T> - type of elements
     */
    private static class Element<T>{
        Element<T> prev;
        Element<T> next;
        T value;

        public Element(Element<T> prev, T value, Element<T> next) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            public boolean hasNext() {
                checkIndex(position);
                return LinkedArray.this.size > position;
            }

            public T next() {
                checkIndex(position);
                return LinkedArray.this.get(position++);
            }

            public void remove() {

            }
        };
    }
}
