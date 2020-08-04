package dst.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    private T[] data = (T[]) new Object[DEFAULT_CAPACITY];

    public boolean empty() {
        return size == 0;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }

        return data[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        T obj = data[size - 1];
        data[size - 1] = null;
        size--;
        return obj;
    }

    public T push(T element) {
        ensureCapacity();
        data[size] = element;
        size++;
        return element;
    }

    public int search(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return size - i;
            }
        }
        return -1;
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

}
