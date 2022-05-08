package lesson6;

import java.util.LinkedList;

public class TreeTraversal {
    static Node<String> getTree() {
        // Дерево-пример
        Node<String> nodeG = new Node<>("g");
        Node<String> nodeE = new Node<>("e");
        Node<String> nodeH = new Node<>("h");

        Node<String> nodeD = new Node<>("d", null, nodeG);
        Node<String> nodeF = new Node<>("f", null, nodeH);

        Node<String> nodeB = new Node<>("b", nodeD, null);
        Node<String> nodeC = new Node<>("c", nodeE, nodeF);

        return new Node<>("a", nodeB, nodeC);
    }

    static void horizontal(Node<?> root) {
        if (root != null) {
            LinkedList<Node<?>> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                Node<?> temp = queue.removeFirst();
                System.out.print(temp);
                System.out.println(", очередь до добавление: " + queue);
                if (temp.left != null) {
                    queue.addLast(temp.left);
                }
                if (temp.right != null) {
                    queue.addLast(temp.right);
                }
                System.out.println("Очередь после добавления: " + queue);
                System.out.println();
            }
        } else {
            System.out.println("Пустое дерево");
        }
    }

    static void preorder(Node<?> root) {
        if (root != null) {
            // NLR
            System.out.println("Вывожу " + root);

            System.out.println("Из " + root + " пошел влево");
            preorder(root.left);

            System.out.println("Из " + root + " пошел вправо");
            preorder(root.right);
        }
    }

    static void inorder(Node<?> root) {
        if (root != null) {
            // LNR
//            System.out.println("Из " + root + " пошел влево");
            inorder(root.left);

//            System.out.println("Вывожу " + root);
            System.out.println(root);

//            System.out.println("Из " + root + " пошел вправо");
            inorder(root.right);
        }
    }

    static void postorder(Node<?> root) {
        if (root != null) {
            // LRN
            System.out.println("Из " + root + " пошел влево");
            postorder(root.left);

            System.out.println("Из " + root + " пошел вправо");
            postorder(root.right);

            System.out.println("Вывожу " + root);
        }
    }
}
