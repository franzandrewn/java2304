package lesson7;

import com.google.gson.Gson;
import lesson6.Person;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void exceptions() {
        // Исключения - особенные ситуации в работе программы, которые приводят к остановке JVM
//        System.out.println(5 / 0);
//        int[] arr = new int[0];
//        System.out.println(arr[0]);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (b != 0) {
            System.out.println("Частное a и b = " + (a / b));
        } else {
            System.out.println("Нельзя делить на 0");
        }
    }

    static void tryCatch() {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Частное a и b = " + (a / b));
        } catch (InputMismatchException ex) {
            System.out.println("Вы ввели не целое число");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (ArithmeticException ex) {
            System.out.println("Вы ввели вторым числом 0, на ноль делить нельзя");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("Какое-то другое исключение");
        } finally {
            System.out.println("Конец try..catch");
            sc.close();
        }
    }

    static void typesOfExceptions() {
        // Обрабатываемое исключение
        try {
            FileReader in = new FileReader("123");
        } catch (FileNotFoundException | ArithmeticException exception) {
            System.out.println(exception.getMessage());
        }
        // Необрабатываемое исключение
        System.out.println(5 / 0);
    }


    static void throwsKeyword() throws FileNotFoundException {
        // Ключевое слово throws сообщает, что метод может "бросить" исключение внутри блока кода
        FileReader in = new FileReader("123");
    }

    static void newExceptionsAndThrow() throws InputNotPositiveException {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i <= 0) {
            throw new InputNotPositiveException(); // "бросание" нового исключения - если оно не обработано, остановка jvm
        }
        System.out.println(i);
    }

    // 1. Создать исключение NameTooLongException, которое является обрабатываемым (наследуется от Exception)
    // Внутри определить конструктор без аргументов,
    // который вызывает конструктор Exception (через super) со строкой "Имя слишком длинное"
    // 2. Создать метод static String readName() throws NameTooLongException,
    // внутри которого создается объект Scanner и считывается строка с именем пользователя (через nextLine())
    // В случае, если длина строки >100, "бросить" исключение NameTooLongException
    // В случае правильного имени, вернуть имя
    // 3. В psvm вызвать метод readName() и обработать исключение с помощью try..catch
    // В случае правильного имени, поприветствовать пользователя, в случае исключения вывести сообщение исключения
    static void task1() {
        try {
            String name = readName();
            System.out.println("Привет, " + name);
        } catch (NameTooLongException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static String readName() throws NameTooLongException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() > 10) {
            throw new NameTooLongException();
        }
        return s;
    }

    static void byteStreamsRead() {
        // Потоки байт
        try {
            FileInputStream in = new FileInputStream("test.txt");
            // r
            System.out.println("r");
            System.out.println(Integer.toHexString(in.read()));
            // ы
            System.out.println("ы");
            System.out.println(Integer.toHexString(in.read()));
            System.out.println(Integer.toHexString(in.read()));
            // 国
            System.out.println("国");
            System.out.println(Integer.toHexString(in.read()));
            System.out.println(Integer.toHexString(in.read()));
            System.out.println(Integer.toHexString(in.read()));
            // 😀
            System.out.println("\uD83D\uDE00");
            System.out.println(Integer.toHexString(in.read()));
            System.out.println(Integer.toHexString(in.read()));
            System.out.println(Integer.toHexString(in.read()));
            System.out.println(Integer.toHexString(in.read()));
            // Конец файла
            System.out.println("Конец файла: ");
            int end = in.read();
            System.out.println(Integer.toHexString(end) + " " + end);
            System.out.println(in.read());

            in.close();
        } catch (IOException ex) {
            System.out.println("Ошибка ввода вывода: " + ex.getMessage());
        }
    }

    static void byteStreamsCopy() {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("logo.svg");
            out = new FileOutputStream("logo_copy.svg");
            // копирование
            int i = in.read();
            while (i != -1) {
                out.write(i);
                i = in.read();
            }
        } catch (IOException ex) {
            System.out.println("Ошибка ввода вывода: " + ex.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    static void tryWithResources() {
        try (FileInputStream in = new FileInputStream("test.txt");
            FileOutputStream out = new FileOutputStream("test_copy.txt")) {
            int i = in.read();
            while (i != -1) {
                out.write(i);
                i = in.read();
            }
        } catch (IOException ex) {
            System.out.println("Ошибка ввода вывода: " + ex.getMessage());
        }
    }

    static void charStreams() {
        try (FileReader in = new FileReader("test1.txt");
            FileWriter out = new FileWriter("test1_copy.txt")) {
            int i = in.read();
            while (i != -1) {
                char c = (char) i;
                System.out.println("Символ: " + c);
                if (c < 'а' || c > 'я') {
                    out.write(i);
                }
                i = in.read();
            }
        } catch (IOException ex) {
            System.out.println("Ошибка ввода вывода: " + ex.getMessage());
        }
    }

    static void bufferedStreams() {
        // Буферизированные потоки символов
        try (BufferedReader in =  new BufferedReader(new FileReader("test1.txt"));
             BufferedWriter out = new BufferedWriter(new FileWriter("test1_copy.txt"))) {
            int i = in.read();
            while (i != -1) {
                char c = (char) i;
                System.out.println("Символ: " + c);
                if (c < 'а' || c > 'я') {
                    out.write(i);
                }
                i = in.read();
            }
        } catch (IOException ex) {
            System.out.println("Ошибка ввода вывода: " + ex.getMessage());
        }

        // Буферизированные потоки байт
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("test1.txt"));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("test1_copy.txt"))) {
            int i = in.read();
            while (i != -1) {
                out.write(i);
                i = in.read();
            }
        } catch (IOException ex) {
            System.out.println("Ошибка ввода вывода: " + ex.getMessage());
        }
    }

    // Сериализация - превращение объекта в набор байт/символов
    // Десериализация - восстановление объекта из набора байт/символов
    static void objectStreams() {
        Person p = new Person("Andrew", 23);
        p.password="passw0rd";
        p.count = 2;
        try (ObjectOutputStream outObj = new ObjectOutputStream(new FileOutputStream("person"))) {
            outObj.writeObject(p);
        } catch (IOException ex) {
            System.out.println("Ошибка IO");
        }
        Person p2 = null;
        try (ObjectInputStream inObj = new ObjectInputStream(new FileInputStream("person"))) {
            p2 = (Person) inObj.readObject();
        } catch (IOException ex) {
            System.out.println("Ошибка IO");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(p);
        System.out.println(p2);
        System.out.println(p == p2);
        System.out.println(p.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p2.count);
        System.out.println(p2.password);
    }

    static void jsonGson() {

        // Serialization
//        System.out.println(gson.toJson(1));            // ==> 1
//        System.out.println(gson.toJson("abcd"));       // ==> "abcd"
//        System.out.println(gson.toJson(10L)); // ==> 10
//        System.out.println(gson.toJson(1.25)); // ==> 1.25
        int[] values = { 1 };
//        System.out.println(gson.toJson(values));       // ==> [1]
//        System.out.println(gson.toJson(null)); // ==> null

// Deserialization
//        int one = gson.fromJson("1", int.class);
//        Integer oneInt = gson.fromJson("1", Integer.class);
//        Long oneLong = gson.fromJson("1", Long.class);
//        Boolean falseBool = gson.fromJson("false", Boolean.class);
//        String str = gson.fromJson("\"abc\"", String.class);
//        String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);
//        System.out.println(one);
//        System.out.println(oneInt);
//        System.out.println(oneLong);
//        System.out.println(falseBool);
//        System.out.println(str);
//        System.out.println(Arrays.toString(anotherStr));

        Gson gson = new Gson();
        Person p = new Person("Andrew", 23);
        p.password="passw0rd";
        p.count = 2;
        String pJson = gson.toJson(p);
        System.out.println(pJson);


        Person p2 = gson.fromJson(pJson, Person.class);
        System.out.println(p2);
        System.out.println(p);
        System.out.println(p == p2);

        Human john = null;
        try (FileReader johnJson = new FileReader("john.json")){
            john = gson.fromJson(johnJson, Human.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(john);
        System.out.println(john.getCity());
    }

    static void maven() {

    }

    // Добавить gson в проект (или вручную, или через создание нового проекта maven)
    // Объект любого класса превратить в json с помощью toJson()
    static void task2() {

    }

    public static void main(String[] args) throws FileNotFoundException {
        // Исключения
//        exceptions();
        // Блок try..catch
//        tryCatch();
//        typesOfExceptions();
        // Ключевые слова throws
//        throwsKeyword();
        // Свои исключения
//        newExceptionsAndThrow();
//        task1();
        // Потоки ввода/вывода (I/O streams)
        // Потоки байт
//        byteStreamsRead();
//        byteStreamsCopy();
        // try-with-resources
//        tryWithResources();
        // Потоки символов
//        charStreams();
        // Буферизированные потоки
//        bufferedStreams();
        // Сериализация, десериализация
        // Потоки объектов
//        objectStreams();
        // json, Gson
        jsonGson();
        // Maven
        maven();
    }
}
