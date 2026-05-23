package T1;

import D1.Stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack, Iterable {
    int size = 0;
    int capacity;
    Object[] arr = {};

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        arr = new Object[capacity];
    }

    @Override
    public boolean push(Object value) {
        if (isFull())
            return false;
        arr[size] = value;
        size++;
        return true;
    }

    @Override
    public Object pop() {
        if (isEmpty())
            return false;
        Object e = arr[0];
        System.arraycopy(arr, 1, arr, 0, size - 1);
        size--;
        return e;
    }

    @Override
    public Object peek() {
        if (isEmpty())
            return false;
        return arr[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
