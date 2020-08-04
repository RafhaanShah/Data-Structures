package dst.arraylist;

public class ArrayList<T> {

    public int size = 0;

    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    private T[] data = (T[]) new Object[DEFAULT_CAPACITY];

    public void add(T element) {
        ensureCapacity();
        data[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, T element) {
        ensureCapacity();

        T[] temp = (T[]) new Object[data.length];
        temp[index] = element;

        for (int i = 0; i < size; i++) {
            if (i < index) {
                temp[i] = data[i];
            }

            if (i > index) {
                temp[i + 1] = data[i];
            }
        }

        data = temp;
        size++;
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

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T remove(int index) {
        T elem = get(index);
        shrinkList(index);
        return elem;
    }

    public boolean remove(T element) {
        int indexToRemove = indexOf(element);

        if (indexToRemove < 0) {
            return false;
        }

        shrinkList(indexToRemove);
        return true;
    }

    public void set(int index, T element) {
        checkIndex(index);
        data[index] = element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > (size - 1)) {
            throw new IndexOutOfBoundsException();
        }
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

    private void shrinkList(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size] = null;
        size--;
    }

}
