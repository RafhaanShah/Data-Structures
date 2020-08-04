package dst.stack;

import java.util.EmptyStackException;

public class Stack<T> {

    private int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data = new Object[DEFAULT_CAPACITY];

    public boolean empty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            return null;
        }

        return (T) data[size - 1];
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        Object obj = data[size - 1];
        data[size - 1] = null;
        size--;
        return (T) obj;
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

    private void ensureCapacity() {
        if (data.length == size) {
            Object[] temp = new Object[data.length + DEFAULT_CAPACITY];
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

}
