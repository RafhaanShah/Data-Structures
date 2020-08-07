package dst.tree;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T element) {
        root = add(root, element);
    }

    public boolean contains(T element) {
        return contains(root, element);
    }

    public void remove(T element) {
        root = remove(root, element);
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    private Node<T> add(Node<T> current, T element) {
        if (current == null) {
            return new Node<T>(element);
        }

        int i = element.compareTo(current.data);
        if (i < 0) {
            current.left = add(current.left, element);
        }

        else if (i > 0) {
            current.right = add(current.right, element);
        }

        return current;
    }

    private boolean contains(Node<T> current, T element) {
        if (current == null) {
            return false;
        }

        int i = element.compareTo(current.data);
        if (i < 0) {
            return contains(current.left, element);
        }

        if (i > 0) {
            return contains(current.right, element);
        }

        return true;
    }

    private Node<T> remove(Node<T> current, T element) {
        if (current == null) {
            return current;
        }

        int i = element.compareTo(current.data);
        if (i < 0) {
            current.left = remove(current.left, element);
            return current;
        }

        if (i > 0) {
            current.right = remove(current.right, element);
            return current;
        }

        if (current.left == null && current.right == null) {
            return null;
        }

        if (current.right == null) {
            return current.left;
        }

        if (current.left == null) {
            return current.right;
        }

        T smallest = findMin(current.right);
        current.data = smallest;
        current.right = remove(current.right, smallest);
        return current;
    }

    private T findMin(Node<T> current) {
        if (current.left == null) {
            return current.data;
        } else {
            return findMin(current.right);
        }
    }

    private void printInOrder(Node<T> current) {
        if (current == null) {
            return;
        }

        printInOrder(current.left);
        System.out.print(current.data + " ");
        printInOrder(current.right);
    }

    private void printPreOrder(Node<T> current) {
        if (current == null) {
            return;
        }

        System.out.print(current.data + " ");
        printPreOrder(current.left);
        printPreOrder(current.right);
    }

    private void printPostOrder(Node<T> current) {
        if (current == null) {
            return;
        }

        printPreOrder(current.left);
        printPreOrder(current.right);
        System.out.print(current.data + " ");
    }

    private class Node<E> {

        private Node<E> left;
        private Node<E> right;
        private E data;

        public Node(E d) {
            data = d;
        }

    }

}
