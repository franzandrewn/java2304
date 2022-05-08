package lesson6;

import lesson3.Animal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import static lesson6.SearchAlgorightms.*;
import static lesson6.SortingAlgorithms.*;
import static lesson6.TreeTraversal.*;

public class Main {
    static void graphs() {
        // Граф - набор узлов связанных ребрами
    }


    static void trees() {
        // Деревья - подтип графов с отсутствием циклов
        // Бинарные деревья - деревья, узлы которых могут иметь максимум двух наследников: левый и правый
        Node<String> root = getTree();
        System.out.println(root);

        System.out.println(root.left);
        System.out.println(root.right);

        System.out.println(root.left.left.right);

//        System.out.println(root.left.right.left);
//        if (root.left != null && root.left.right != null) {
//            System.out.println(root.left.right.left);
//        }
    }

    static void treeTraversal() {
        Node<String> root = getTree();
        // Горизонтальный обход (horizontal)
        horizontal(root);
        // Обходы в глубину:
        // Прямой (preorder, NLR)
        preorder(root);
        // Центрированный (inorder, LNR)
        inorder(root);
        // Обратный (postorder, LRN)
        postorder(root);
    }

    static void binarySearchTree() {
        // Бинарное дерево поиска - бинарное дерево, у которого предок больше левого потомка
        // и меньше или равен правому потомку
        LinkedList<Integer> ints = new LinkedList<>();
        ints.add(5);
        ints.add(1);
        ints.add(0);
        ints.add(-1);
        ints.add(10);
        ints.add(7);
        ints.add(12);
        ints.add(13);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(ints);
        horizontal(bst.getRoot());

        System.out.println(bst.containsNode(8));
        System.out.println(bst.containsNode(7));

        inorder(bst.getRoot());
    }


    static void search() {
        // Алгоритм поиска - найти индекс элемента в структуре данных
        // Если структура неотсортированная, то есть только один вариант - линейный поиск
        int[] arr = new int[]{1, 5, 7, -10, 6};
        System.out.println(linearSearch(arr, 7));
        System.out.println(linearSearch(arr, -100));

        // Существуют алгоритмы, производящие поиск в отсортированных структурах и они зачастую быстрее
        // Бинарный поиск - деление диапазона поиска на два каждую итерацию
        int[] sortedArr = new int[]{1, 4, 7, 10, 17, 19, 20};
        System.out.println(binarySearch(sortedArr, 10));
        System.out.println(Arrays.binarySearch(sortedArr, 10));
        System.out.println(binarySearch(sortedArr, 11));
        System.out.println(Arrays.binarySearch(sortedArr, 11));
        System.out.println(binarySearch(sortedArr, 20));
        System.out.println(Arrays.binarySearch(sortedArr, 20));

        // Интерполяционный поиск - поиск основанный на попытке угадать индекс (данные должны быть равномерными)
        int[] evenIncArr = new int[]{1, 4, 7, 10, 17, 19, 20};
        System.out.println(interpolationSearch(evenIncArr, 10));
        System.out.println(interpolationSearch(evenIncArr, 11));
        System.out.println(interpolationSearch(evenIncArr, 20));

        int[] zeroToHundred = new int[51];
        for (int i = 0; i < zeroToHundred.length; i++) {
            zeroToHundred[i] = 2 * i;
        }
        System.out.println(interpolationSearch(zeroToHundred, 10));
        System.out.println(interpolationSearch(zeroToHundred, 58));
        System.out.println(interpolationSearch(zeroToHundred, 11));
    }


    static void sort() {
        // Сортировка - поставить элементы в правильном порядке (по возрастанию/по убыванию)
        int[] arr = new int[]{1, 5, 7, -10, 6, 10, 7, -15, 0, 67, 39, 1};
        // Сортировка пузырьком
        bubbleSort(arr);
        // Быстрая сортировка
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void generics() {
        Node<Integer> nodeInt = new Node<>(1);
        Integer fromNodeInt = nodeInt.getInfo();
        System.out.println(nodeInt + " " + fromNodeInt.doubleValue());

        Node<String> nodeString = new Node<>("asd");
        String fromNodeString = nodeString.getInfo();
        System.out.println(nodeString + " " + fromNodeString.replace("a", "b"));

        Cage<Tiger> tigerCage = new Cage<>(new Tiger(), 12, 12, 12);
        System.out.println(tigerCage);
        Cage<Bear> bearCage = new Cage<>(new Bear(), 14, 14, 14);
        System.out.println(bearCage);
        Cage<Animal> animalCage = new Cage<>(new Animal(), 1, 1, 1);
//        Cage<String> stringCage;
    }

    static void comparable() {
        Person p1 = new Person("Andrew", 23);
        Person p2 = new Person("Vasiliy", 24);
        Person p3 = new Person("Vladislav", 23);
        System.out.println(p1.compareTo(p2));
        System.out.println(p1.compareTo(p3));

        BinarySearchTree<Person> peopleTree = new BinarySearchTree<>();
        peopleTree.add(p1);
        peopleTree.add(p2);
        peopleTree.add(p3);
        inorder(peopleTree.getRoot());

        LinkedList<Person> people = new LinkedList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
//        people.sort(Comparator.comparing(x -> x));
        people.sort((person1, person2) -> {
            if (person1.age == person2.age) {
                return person1.name.length() - person2.name.length();
            } else {
                return person1.age - person2.age;
            }
        });
        System.out.println(people);
    }

    public static void main(String[] args) {
        // Деревья
//        trees();
        // Обход деревьев
//        treeTraversal();
        // Бинарное дерево поиска
//        binarySearchTree();
        // Алгоритмы поиска
//        search();
        // Алгоритмы сортировки
//        sort();
        // Обобщенное программирование
//        generics();
        // Интерфейс Comparable
        comparable();
    }
}
