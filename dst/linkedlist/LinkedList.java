package dst.linkedlist;

public class LinkedList<T> {

    private Node<T> head;

    private int size = 0;

    public void add(T element) {
        Node<T> node = new Node<T>(element, null);

        if (isEmpty()) {
            head = node;
            size++;
            return;
        }

        Node<T> current = head;
        while (current.hasNext()) {
            current = current.next;
        }

        current.next = node;
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = new Node<T>(element, null);

        if (isEmpty()) {
            head = node;
            size++;
            return;
        }

        if (index == 0) {
            node.next = head;
            head = node;
            size++;
            return;
        }

        Node<T> prev = null;
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        prev.next = node;
        node.next = current;
        size++;
    }

    public void clear() {
        if (isEmpty()) {
            return;
        }

        Node<T> current = head;
        while (current != null) {
            Node<T> temp = current.next;
            current.next = null;
            current = temp;
        }

        size = 0;
    }

    public boolean contains(T element) {
        if (head == null) {
            return false;
        }

        Node<T> current = head;
        while (current != null) {
            if (element.equals(current.data)) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }

        if (element.equals(head.data)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> prev = null;
        Node<T> current = head;
        while (current != null) {
            if (element.equals(current.data)) {
                prev.next = current.next;
                size--;
                return true;
            }

            prev = current;
            current = current.next;
        }

        return false;
    }

    public T remove(int index) {
        checkIndex(index);

        if (index == 0) {
            T temp = head.data;
            head = head.next;
            size--;
            return temp;
        }

        Node<T> prev = null;
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }

        size--;
        prev.next = current.next;
        return current.data;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private class Node<E> {

        private Node<E> next;
        private E data;

        public Node(E d, Node<E> n) {
            data = d;
            next = n;
        }

        public boolean hasNext() {
            return next != null;
        }

    }
}
