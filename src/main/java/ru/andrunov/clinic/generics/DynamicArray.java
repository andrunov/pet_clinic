package ru.andrunov.clinic.generics;

import java.util.Arrays;
import java.util.Iterator;

/**
 * collection of elements
 * builds by inner array
 */
public class DynamicArray<T> implements Iterable<T> {
    private int size;
    private Object[] array;


    /**
     * constructor
     * @param capacity - capacity of our DynamicArray
     */
    public DynamicArray(int capacity) {
        this.array = new Object[capacity];
    }

    /**
     * constructor
     */
    public DynamicArray() {
        this.array = new Object[10];
    }


    /**
     * trims this.array to  DynamicArray length
     */
    public void trimToSize() {
        if (this.size < this.array.length) {
            this.array = Arrays.copyOf(this.array, this.size);
        }
    }

    /**
     * quantity of elements in DynamicArray
     * @return size - quantity
     */
    public int size() {
        return this.size;
    }

    /**
     * our DynamicArray has no elements
     * @return true if has no elements
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * our DynamicArray contains send element
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * first index of send element
     * @param o
     * @return - index of object or -1 if there has not that object
     */
    public int indexOf(Object o) {
        int index = -1;
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (array[i]==null) {
                    index = i;
                    break;
                }
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(array[i])) {
                    index = i;
                    break;
                }
        }
        return index;
    }


    /**
     * gets object by send index
     * @param index - index for get element
     * @return - object
     */
    public T get(int index) {
        checkIndex(index);
        return (T)array[index];
    }

    /**
     *
     * @param index - index for set element
     * @param element - object to set
     */
    public void set(int index, T element) {
       checkIndex(index);
       this.array[index] = element;
    }


    /**
     * add new element to end
     * @param t - object to add
     */
    public void add(T t) {
        this.size++;
        if (this.array.length <= this.size()){
            this.array = Arrays.copyOf(this.array,this.size*2/3);
        }
        this.array[size()-1] = t;
    }


    /**
     * remove element from specified position
     * @param index - position index
     */
    public void remove(int index) {
        checkIndex(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(this.array, index+1, this.array, index,
                    numMoved);
        this.array[--size] = null;

    }

    /**
     * check that index in range of DynamicArray size
     * @param index - specified index
     */
    private void checkIndex(int index){
        if (index > this.size() || index < 0){
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d",index,this.size));
        }
    }

    /**
     * remove first occurrence object
     * @param o - object to remove
     */
    public void remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (array[index] == null) {
                    remove(index);
                    break;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(array[index])) {
                    remove(index);
                    break;
                }
            }
    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
        for (int i = 0; i < size; i++)
            this.array[i] = null;

        size = 0;
    }



    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;
            public boolean hasNext() {
                return DynamicArray.this.size > position;
            }

            public T next() {
                return (T)DynamicArray.this.array[position++];
            }

            public void remove() {

            }
        };
    }
}
