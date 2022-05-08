package lesson5;



import java.util.*;

public class Main {
    static void aggregation() {
        // Агрегация - наличие объектов одного класса как полей в другом классе
        Boat b = new Boat(3);
        b.move();
        b.turnEngineOn();
        b.move();

        Engine e = new Engine();
        Boat b1 = new Boat(e, 3);
    }

    static void arrayLists() {
        // Списки - динамические массивы (т.е. массивы, которые могут изменяться по длине)
        // Элементы внутри списков только одного типа и все элементы пронумерованы (индексы)
        // <>,  алмазный оператор (diamond operator) - оператор, позволяющий указать с каким классом работает указанный класс
        // Создание массива строк
        String[] strsArray = new String[5];
        // ArrayList - список, основанный на массиве
        // Создание списка строк
        ArrayList<String> strsList = new ArrayList<>();
//        System.out.println(strsList + ", длина=" + strsList.size());
        // Добавление в конец списка
        strsList.add("asd");
//        System.out.println(strsList + ", длина=" + strsList.size());
        strsList.add("zxc");
//        System.out.println(strsList + ", длина=" + strsList.size());

        // Добавление на индекс
        strsList.add(1, "middle");
//        System.out.println(strsList + ", длина=" + strsList.size());

        // Удалить элемент по индексу
        strsList.remove(1);
//        System.out.println(strsList + ", длина=" + strsList.size());
        // Удалить элемент по значению
        strsList.add("zxc");
        System.out.println(strsList + ", длина=" + strsList.size());
//        strsList.remove("zxc");
//        System.out.println(strsList + ", длина=" + strsList.size());

        // Узнать, есть ли элемент
//        while (strsList.contains("zxc")) {
//            strsList.remove("zxc");
//        }
//        System.out.println(strsList + ", длина=" + strsList.size());

        // Узнать индекс элемента начиная с начала
        System.out.println("Первый 'zxc' на " + strsList.indexOf("zxc") + " индексе");

        // Узнать индекс элемента начиная с конца
        System.out.println("Последний 'zxc' на " + strsList.lastIndexOf("zxc") + " индексе");

//        strsList.clear();
//        System.out.println(strsList + ", длина=" + strsList.size());
//        System.out.println(strsList.isEmpty());

        strsArray = new String[strsList.size()];
        strsList.toArray(strsArray);
        System.out.println(Arrays.toString(strsArray));

        // Получить элемент по индексу
        System.out.println(strsList.get(1));

        // Изменить элемент по индексу
        strsList.set(1, "zxc1");
        System.out.println(strsList);


        ArrayList<String> strs = (ArrayList<String>) strsList.clone();
        ArrayList<String> strsAlt = new ArrayList<>(strsList);
        System.out.println(strs);
        System.out.println(strsList.equals(strs));

        ArrayList<String> strs1 = strsList;
        System.out.println(strs1==strsList);

        strsList.addAll(strs);
        System.out.println(strsList);

//        ArrayList<Integer> ints = new ArrayList<>();
//        ints.add(1);
//        String[] arrInts = new String[ints.size()];
//        ints.toArray(arrInts);
//        System.out.println(Arrays.toString(arrInts));
    }

    static void dimensional() {
        int[][] matrix = new int[3][4];
        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6, 7},
                {8, 9}
        };

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.println("matrix[" + row + "][" + col + "] = " + matrix[row][col]);
            }
        }

        ArrayList<ArrayList<Integer>> listMatrix = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        row2.add(7);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(8);
        row3.add(9);
        listMatrix.add(row1);
        listMatrix.add(row2);
        listMatrix.add(row3);

        System.out.println(listMatrix);

        for (int row = 0; row < listMatrix.size(); row++) {
            for (int col = 0; col < listMatrix.get(row).size(); col++) {
                System.out.println("listMatrix[" + row + "][" + col + "] = " + listMatrix.get(row).get(col));
            }
        }
    }

    static void linkedLists() {
        // LinkedList - список, основанный на большом количестве объектов, связанных друг с другом в определенном порядке
        LinkedList<String> strsList = new LinkedList<>();
//        System.out.println(strsList + ", длина=" + strsList.size());
        // Добавление в конец списка
        strsList.add("asd");
//        System.out.println(strsList + ", длина=" + strsList.size());
        strsList.add("zxc");
//        System.out.println(strsList + ", длина=" + strsList.size());

        // Добавление на индекс
        strsList.add(1, "middle");
//        System.out.println(strsList + ", длина=" + strsList.size());

        // Удалить элемент по индексу
        strsList.remove(1);
//        System.out.println(strsList + ", длина=" + strsList.size());
        // Удалить элемент по значению
        strsList.add("zxc");
        System.out.println(strsList + ", длина=" + strsList.size());
//        strsList.remove("zxc");
//        System.out.println(strsList + ", длина=" + strsList.size());

        // Узнать, есть ли элемент
//        while (strsList.contains("zxc")) {
//            strsList.remove("zxc");
//        }
//        System.out.println(strsList + ", длина=" + strsList.size());

        // Узнать индекс элемента начиная с начала
        System.out.println("Первый 'zxc' на " + strsList.indexOf("zxc") + " индексе");

        // Узнать индекс элемента начиная с конца
        System.out.println("Последний 'zxc' на " + strsList.lastIndexOf("zxc") + " индексе");

//        strsList.clear();
//        System.out.println(strsList + ", длина=" + strsList.size());
//        System.out.println(strsList.isEmpty());
    }

    static void sets() {
        // Множество - структура данных содержащая уникальные элементы
        // HashSet - множество с отсутствием определенного порядка элементов
        HashSet<String> hashSet = new HashSet<>();
        System.out.println(hashSet);
        hashSet.add("zxc");
        hashSet.add("asd");
        hashSet.add("asd");
        hashSet.add("1");
        hashSet.add("я");
        System.out.println(hashSet);
        hashSet.remove("zxc");
        System.out.println(hashSet);
        System.out.println(hashSet.contains("asd"));
        System.out.println(hashSet.contains("zxc"));
        System.out.println(hashSet.size());
        LinkedList<String> strsList = new LinkedList<>();
        strsList.add("asd");
        strsList.add("qwe");
        hashSet.addAll(strsList);
        System.out.println(hashSet);

        // LinkedHashSet - множество сохраняющее порядок добавления элементов
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("zxc");
        linkedHashSet.add("asd");
        linkedHashSet.add("m");
        System.out.println(linkedHashSet);
        linkedHashSet.remove("asd");
        System.out.println(linkedHashSet);

        // TreeSet - множество поддерживающее отсортированный порядок
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("zxc");
        treeSet.add("asd");
        treeSet.add("m");
        treeSet.add("1");
        treeSet.add("я");
        System.out.println(treeSet);

        HashSet<Integer> ints = new HashSet<>();
        ints.add(5);
        ints.add(-600);
        ints.add(7);
        System.out.println(ints);
        System.out.println(Integer.valueOf(5).hashCode() + " " + Integer.valueOf(-600).hashCode() + " " + Integer.valueOf(7).hashCode());

        TreeSet<Integer> ints1 = new TreeSet<>();
        ints1.add(5);
        ints1.add(-600);
        ints1.add(7);
        System.out.println(ints1);
    }

    static void stack() {
        // стек - структура данных, работающая по принципу LIFO (Last In - First Out)
        Stack s = new Stack();
        System.out.println(s);
        s.push(4);
        s.push(3);
        s.push(100);
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s);
    }

    static void queue() {
        Queue q = new Queue();
        System.out.println(q);
        q.queue(4);
        q.queue(3);
        q.queue(100);
        System.out.println(q);
        System.out.println(q.dequeue());
        System.out.println(q);
    }

    static void dequeue() {
        LinkedList<Integer> dequeue = new LinkedList<>();
        // Работа как со стеком
        dequeue.addLast(4);
        dequeue.addLast(3);
        dequeue.removeLast();
        dequeue.clear();
        // Работа как с очередью
        dequeue.addLast(4);
        dequeue.addLast(3);
        dequeue.removeFirst();
    }

    static void maps() {
        // Словари - хранение пар элементов вида ключ-значение
        // Ключи - уникальные значения
        HashMap<String, Integer> map = new HashMap<>();
        // Положить пару Ключ-Значение
        map.put("One", 1);
        map.put("Two", 2);
        System.out.println(map);

        HashMap<Integer, String> secondMap = new HashMap<>();
        secondMap.put(1, "One");
        secondMap.put(2, "Two");

        // Взять по ключу значение
        System.out.println(map.get("One"));
        System.out.println(map.get("Three"));

        // Проверить существование ключа или значение
        System.out.println(map.containsKey("One"));
        System.out.println(map.containsValue(1));

        // Заменить значение по ключу
        map.replace("One", 0);
        System.out.println(map.get("One"));

        map.put("One", 1);
        System.out.println(map.get("One"));
        map.put("Three", 1);
        // Получить множество ключей
        System.out.println(map.keySet());
        // Получить список значений
        System.out.println(map.values());

        // Сохраняет порядок добавления
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // поддерживает отсортированный порядок (по ключам)
        TreeMap<String, Integer> treeMap = new TreeMap<>();
    }

    static void forEach() {
        LinkedList<String> strsList = new LinkedList<>();
        strsList.add("asd");
        strsList.add("zxc");
        strsList.add(1, "middle");
        for (String str : strsList) {
            System.out.println(str);
        }

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("zxc");
        treeSet.add("asd");
        treeSet.add("m");
        treeSet.add("1");
        treeSet.add("я");
        for (String str : treeSet) {
            System.out.println(str);
        }

        HashMap<String, Integer> map = new HashMap<>();
        // Положить пару Ключ-Значение
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 1);
        for (Integer i : map.values()) {
            System.out.println(i);
        }
        for (String s : map.keySet()) {
            System.out.println("Ключ: " + s + " значение: " + map.get(s));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + " значение: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Аггрегация
//        aggregation();
        // Java Collection Framework
        // Структуры данных - типы данных, позволяющие хранить много элементов в себе
        // ArrayList
//        arrayLists();
        // Многомерные массивы и списки
//        dimensional();
        // LinkedList
//        linkedLists();
        // Множества
//        sets();
        // Стек
//        stack();
        // Очередь
//        queue();
        // Двустороняя очередь
//        dequeue();
        // Словарь
//        maps();
        // Специальный цикл for
        forEach();
    }
}
