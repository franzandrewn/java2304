package lesson6;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Iterable<T> iterable) {
        for (T value : iterable) {
            add(value);
        }
    }

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }
        if (value.compareTo(current.info) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.info) > 0) {
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node<T> current, T value) {
        if (current == null) {
            return false;
        }
        if (value.compareTo(current.info) == 0) {
            return true;
        } else if (value.compareTo(current.info) < 0) {
            return containsNodeRecursive(current.left, value);
        } else {
            return containsNodeRecursive(current.right, value);
        }
    }

    public boolean containsNode(T value) {
        return containsNodeRecursive(root, value);
    }

    public Node<T> getRoot() {
        return root;
    }


}
