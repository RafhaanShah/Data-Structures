package dst.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    private T[] data = (T[]) new Object[DEFAULT_CAPACITY];

    public boolean empty() {
        return size == 0;
    }

    public T head() {
        if (size == 0) {
            return null;
        }

        return data[0];
    }

    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        T obj = data[0];
        shiftQueue();
        return obj;
    }

    public T enqueue(T element) {
        ensureCapacity();
        data[size] = element;
        size++;
        return element;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (data.length == size) {
            T[] temp = (T[]) new Object[data.length + DEFAULT_CAPACITY];
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    private void shiftQueue() {
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size] = null;
        size--;
    }

}
