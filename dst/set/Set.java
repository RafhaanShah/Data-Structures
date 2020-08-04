package dst.set;

public class Set<T> {

    public int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data = new Object[DEFAULT_CAPACITY];

    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }

        ensureCapacity();
        data[size] = element;
        size++;
        return true;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        size = 0;
    }

    public boolean contains(T element) {
        return indexOf(element) > -1;
    }

    private int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(T element) {
        int indexToRemove = indexOf(element);

        if (indexToRemove < 0) {
            return false;
        }

        for (int i = indexToRemove; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size] = null;
        size--;

        return true;
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
