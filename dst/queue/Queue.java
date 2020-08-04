package dst.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data = new Object[DEFAULT_CAPACITY];

    public boolean empty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T head() {
        if (size == 0) {
            return null;
        }

        return (T) data[0];
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Object obj = data[0];
        shiftQueue();
        return (T) obj;
    }

    public T enqueue(T element) {
        ensureCapacity();
        data[size] = element;
        size++;
        return element;
    }

    private void ensureCapacity() {
        if (data.length == size) {
            Object[] temp = new Object[data.length + DEFAULT_CAPACITY];
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
