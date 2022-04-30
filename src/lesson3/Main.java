package lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    static void arrayAlgorithms() {
        // Простейшие алгоритмы массивов
        int[] ints = new int[]{1, 2, 4, 8, 5, -1, 6, 8};
        // Нахождение максимального элемента, минимального элемента и их индексов
        int max = ints[0];
        int maxIndex = 0;
        int min = ints[0];
        int minIndex = 0;
        for (int i = 1; i < ints.length; i++) {
            System.out.println("Максимум до: " + max + ", минимум до: " + min + ", ints[i]: " + ints[i]);
            if (ints[i] > max) {
                max = ints[i];
                maxIndex = i;
            }
            if (ints[i] < min) {
                min = ints[i];
                minIndex = i;
            }
        }
        System.out.println("Максимальное значение массива: " + max + " на индексе: " + maxIndex);
        System.out.println("Минимальное значение массива: " + min + " на индексе: " + minIndex);

        // Алгоритм поиска индекса элемента
        System.out.println("Какой элемент найти");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        // Найти индекс элемента со значением target
        int targetIndex = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == target) {
                targetIndex = i;
                break;
            }
        }
        if (targetIndex != -1) {
            System.out.println("Элемент: " + target + " на индексе: " + targetIndex);
        } else {
            System.out.println("Элемент не найден");
        }
    }

    static void methods() {
        // Методы как подпрограммы
        // Метод - именованный блок кода с входными данными и выходным значением
        // Вызов метода - запуск блока кода по имени
        printSomething();
        printSomething();
        // метод с входящими значениями
        // В вызове метода с входящими значениями необходимо предоставить значения аргументам
        printAdd(3, 5);
        printAdd(-100, 100);
        int q = 125;
        printAdd(q, 1);
        // метод с выходящим значением
        int mul = calculateMultiply(5, 11);
        System.out.println("Переменная mul = " + mul);
        System.out.println("10 * 11 = " + calculateMultiply(10, 11));
    }

    static void scope() {
        // Область видимости
        int x = 6;
        vid();
        System.out.println(x);

        int y = 1;
        if (x > 5) {
            y = 7;
            int z = 5;
            System.out.println(y);
        }
        if (x > 1) {
            System.out.println(y);
        }
        System.out.println(y);
    }

    static void valueAndReference() {
        // Передача параметров по значению и по ссылке
        // Переменные
        // 1. Примитивные
        // 2. Ссылочные
        int temp = 100;
        changeInt(temp);
        System.out.println(temp);

        int[] arrInt = new int[]{100};
        changeArr(arrInt);
        System.out.println(Arrays.toString(arrInt));
    }

    static void task1() {
        // Методы создаем внутри класса, но вне psvm
        // Каждый метод начинаем с static
        /*
        Написать метод с названием printInfo, который принимает как аргументы два целых числа
        Блок кода метода выводит эти два числа в виде "Первое число = " и "Второе число =
        Вызвать метод printInfo дважды с разными значениями
         */
        printInfo(5, 7);
        printInfo(1, -100);
    }

    static void task2() {
        // task2
        /*
        Написать метод с названием threeDoubleProduct, который принимает три дробных числа
        и возвращает дробное число, равное произведению всех трех аргументов
        Вызвать метод threeDoubleProduct со значениями 0.001, 1000 и -1.257, вывести результат на экран
         */
        System.out.println("x*y*z = " + threeDoubleProduct(0.001, 1000, -1.257));
    }

    static void task3() {
        // task3 (HW0)
        /*
        Создать метод, принимающий массив целых чисел ints и целое число target
        и возвращает индекс элемента, равного target, внутри ints
         */
    }

    static void a() {
        System.out.println("a before b");
        b();
        System.out.println("a after b");
    }

    static void b() {
        System.out.println("b before c");
        c();
        System.out.println("b after c");
    }

    static void c() {
//        System.out.println("c" + (5/0));
        System.out.println("c");
    }

    static void recursion() {
        // рекурсия - запуск метода из самого себя
        // Бесконечная рекурсия - не остановится, пока не дойдет до границ стека
//        infRec();
        // Рекурсия, ограниченная каким-либо условием
        rec(5);
    }

    static void oop() {
        // ООП - Объекно-Ориентированное Программирование
        // Один класс - один файл
        String vanyaName = "Vanya";
        int vanyaAge = 24;
        double vanyaMoney = 1000.1;

        // Класс - пользовательский тип данных
        // Создание переменной класса - объекта
        // Объект состоит из двух частей:
        // 1. Состояние - набор полей
        Person person = new Person();
        System.out.println("Имя человека: " + person.name);
        System.out.println("Возраст человека: " + person.age);
        System.out.println("Количество денег: " + person.money);
        person.name = "Vanya";
        person.age = 24;
        person.money = 1000.1;
        System.out.println("Имя человека: " + person.name);
        System.out.println("Возраст человека: " + person.age);
        System.out.println("Количество денег: " + person.money);
        // 2. Поведение - набор методов
        person.print();
        System.out.println(person.getMoney());

        Person person2 = new Person();
        person2.name = "Andrew";
        person2.age = 23;
        person2.money = 100;
        person2.print();
        System.out.println(person2.getMoney());
    }

    static void task4() {
        /*
        Создать класс Animal
        три поля: String name, int age, String kind
        два метода:
            void print(), который выводит всю информацию об объекте
            void makeSound(), который выводит
                "Мяу", если kind.equals("cat");
                "Гав", если kind.equals("dog");
                "Звук", если kind не подходит под два предыдущих условия
        в psvm создать один объект класса Animal,
        заполнить значения у всех полей,
        вызвать оба метода
         */
        Animal animal = new Animal();
        animal.name = "Barsik";
        animal.age = 4;
        animal.kind = "cat";
        animal.print();
        animal.makeSound();
    }

    static void constructors() {
        // конструкторы - специальные блоки кода, позволяющий заполнить поля значениями в момент создания объекта
        Person person3 = new Person("Andrew", 23, 100);
        person3.print();
        System.out.println(person3.getMoney());
    }

    static void stringTask() {
        /*
        Спросить у пользователя строку с помощью nextLine()
        В полученной строке заменить все слова "телефон" на "phone"
        и убрать лишние пробелы
         */
    }

    public static void main(String[] args) {
        // Алгоритмы на массивах
        arrayAlgorithms();
        // Методы
        methods();
        // Область видимости
        scope();
        // Передача параметров и виды переменных
        valueAndReference();
        // task1
        task1();
        // task2
        task2();
        // task3
        task3();
        // Запуск методов из методов
        a();
        // Рекурсия
        recursion();
        // ООП
        // Классы, объекты, поля и методы
        oop();
        // task4
        task4();
        // Конструкторы
        constructors();
        // stringTask
        stringTask();

    }

    // Синтаксис объявления метода
    /*
    тип_возвращаемого_значения имя_метода(набор_входящих_значений) {
        блок кода
    }
     */
    // void - отсутствие выходящего значения
    // пустые круглые скобки - отсутствие входящих значений
    static void printSomething() {
        System.out.println("Это - printSomething()");
        System.out.println("Он выводит две строки");
    }
    // x и y - аргументы метода
    // метод под названием printAdd, принимающий два целых числа
    // выводящий результат сложения на экран
    static void printAdd(int x, int y) {
        // x и y внутри блока кода - обычные переменные
        System.out.println("Сумма " + x + " и " + y + " = " + (x + y));
    }
    static int calculateMultiply(int x, int y) {
        // return - операция возврата какого-либо значения в место вызова
        return x * y;
    }

    // передача переменного количества аргументов одного типа
    static void printAllInts(int ... ints) {
        for (int i : ints) {
            System.out.println(i);
        }
    }

    static void vid() {
        int x = 5;
        System.out.println(x);
    }

    static void changeInt(int x) {
        x = 5;
    }

    static void changeArr(int[] ints) {
        ints[0] = 5;
    }

    static void printInfo(int x, int y) {
        System.out.println("Первое число = " + x);
        System.out.println("Второе число = " + y);
    }

    static double threeDoubleProduct(double x, double y, double z) {
        return x * y * z;
    }



    static void infRec() {
        infRec();
    }

    static void rec(int i) {
        System.out.println(i);
        if (i > 0) {
            rec(i - 1);
        }
    }
}
