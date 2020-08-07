package dst.doublylinkedlist;

public class DoublyLinkedList<T> {

    private Node<T> head;

    private int size = 0;

    public void add(T element) {
        Node<T> node = new Node<T>(element);

        if (isEmpty()) {
            head = node;
            size++;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        node.prev = current;
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = new Node<T>(element);

        if (isEmpty()) {
            head = node;
            size++;
            return;
        }

        if (index == 0) {
            node.next = head;
            head.prev = node;
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
        node.prev = prev;

        current.prev = node;
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
            current.prev = null;
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
            Node<T> newHead = head.next;
            newHead.prev = null;
            head = newHead;
            size--;
            return true;
        }

        Node<T> prev = null;
        Node<T> current = head;
        while (current != null) {
            if (element.equals(current.data)) {
                Node<T> next = current.next;
                prev.next = next;
                next.prev = prev;
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
            if (size == 1) {
                head = null;
                size--;
                return temp;
            }

            Node<T> newHead = head.next;
            newHead.prev = null;
            head = newHead;
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
        Node<T> next = current.next;
        prev.next = next;
        next.prev = prev;
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
        private Node<E> prev;
        private E data;

        public Node(E d) {
            data = d;
        }

    }

}
