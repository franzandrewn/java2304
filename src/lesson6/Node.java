package lesson6;

public class Node<I> {
    public I info;
    public Node<I> left;
    public Node<I> right;

    public Node(I info) {
        this.info = info;
        left = null;
        right = null;
    }

    public Node(I info, Node<I> left, Node<I> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public I getInfo() {
        return info;
    }

    public void setInfo(I info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Node{" +
                "info=" + info +
                '}';
    }
}
