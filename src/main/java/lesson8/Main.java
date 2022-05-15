package lesson8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lesson7.Address;
import lesson7.Human;
import lesson7.PhoneNumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    static void builderExamples() {
        // Builder - специальный объект, с помощью которого можно настроить параметры создаваемого объекта
        // Настройки Gson по умолчанию
        Gson gson = new GsonBuilder().create();
        // Настройка "красивой" сериализации
        Gson gsonWithPrettyPrint = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Human john = new Human("John", "Smith", true, 27,
                new Address("212ndStreet", "New York", "NY", "10021-3100"),
                new PhoneNumber[]{new PhoneNumber("home", "212555-1234"), new PhoneNumber("office","646555-4567")},
                new Human[0],
                null);
        String prettyJohn = gsonWithPrettyPrint.toJson(john);
        System.out.println(prettyJohn);

        Gson gsonExcludeFields = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC, Modifier.PRIVATE)
                .create();
        String johnWithoutAddress = gsonExcludeFields.toJson(john);
        System.out.println(johnWithoutAddress);

        Gson gsonIncludeFields = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String johnWithExposedFields = gsonIncludeFields.toJson(john);
        System.out.println(johnWithExposedFields);

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Human with name: ")
                .append(john.getFullName())
                .append(" age: ")
                .append(john.getAge());
        System.out.println(strBuilder);
        // Строки - неизменяемый тип данных
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1.hashCode() + " " + s2.hashCode());
        String s3 = new String("abc");
        System.out.println(s3.hashCode());
    }

    static void scanner() {
//        try (Scanner sc = new Scanner(new FileInputStream("numbers.txt"))) {
//            while (sc.hasNext()) {
//                if (sc.hasNextInt()) {
//                    System.out.println("int " + sc.nextInt());
//                } else if (sc.hasNextDouble()) {
//                    System.out.println("double " + sc.nextDouble());
//                } else {
//                    System.out.println("word " + sc.next());
//                }
//            }
//        } catch (IOException ex) {
//            System.out.println("IO exception " + ex.getMessage());
//        }
        try (Scanner sc = new Scanner(new FileInputStream("nameAge.txt"))) {
            int age = sc.nextInt(); // курсор остановился в конце числа
            sc.nextLine(); // если нет этой строки, берет все символы начиная с курсора и заканчивая '\n'
            String fullName = sc.nextLine();
            System.out.println(age);
            System.out.println(fullName);
            System.out.println(fullName.length());
        } catch (IOException ex) {
            System.out.println("IO exception " + ex.getMessage());
        }
    }

    static void formatting() {
        // Форматирование строк - превращение шаблона строки в итоговую строку путем подстановки значений в определенные места
        Human john = new Human("John", "Smith", true, 27,
                new Address("212ndStreet", "New York", "NY", "10021-3100"),
                new PhoneNumber[]{new PhoneNumber("home", "212555-1234"), new PhoneNumber("office","646555-4567")},
                new Human[0],
                null);
        System.out.println("Human with name: " + john.getFullName() + " and age: " + john.getAge());
        System.out.printf("Human with name: %s and age: %d\n", john.getFullName(), john.getAge());

        System.out.printf("Pi = %f\n", Math.PI);

        System.out.printf("%tD\n", new Date());
        System.out.printf("%8tY%1$8tm%1$8td\n", new Date());

        System.out.printf("%f, %1$+20.10f \n", Math.PI);

        // String.format()
        String s = String.format("%f, %1$+20.10f", Math.PI);
        System.out.println(s);
        s = String.format(Locale.US, "%f, %1$+20.10f", Math.PI);
        System.out.println(s);
        s = String.format("%td %1$tB %1$tY", new Date());
        System.out.println(s);
        s = String.format(Locale.forLanguageTag("es-ES"), "%td %1$tB %1$tY", new Date());
        System.out.println(s);
    }

    // Паттерны проектирования - стандартизированные решения распространенных проблем
    // Порождающие (Синглтон/Singleton, Фабрика/Factory) - паттерны, настраивающие создание объектов
    static void singleton() {
        // Синглтон - класс, у которого может быть максимум один объект и существует глобальный доступ к этому объекту
        // Причины для одного объекта - дорогостоящее создание объекта, нет необходимости в нескольких объектах
        Singleton singleton = Singleton.getInstance("first singleton");
        System.out.println(singleton.value);
        Singleton singleton2 = Singleton.getInstance("second singleton");
        System.out.println(singleton2.value);
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }
    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }

    static void multiThreadBadSingleton() {
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo1 implements Runnable {
        @Override
        public void run() {
            MultiThreadSingleton singleton = MultiThreadSingleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }
    static class ThreadBar1 implements Runnable {
        @Override
        public void run() {
            MultiThreadSingleton singleton = MultiThreadSingleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
    static void multiThreadGoodSingleton() {
        Thread threadFoo = new Thread(new ThreadFoo1());
        Thread threadBar = new Thread(new ThreadBar1());
        threadFoo.start();
        threadBar.start();
    }

    // Структурные (Декоратор/Decorator, Адаптер/Adapter) - паттерны, настраивающие связи между объектами
    static void decorator() {
        Scanner sc = new Scanner(System.in);
        Notifier notifier = new EmailNotifier();

        System.out.println("Vk оповещения? ");
        boolean vkOn = sc.nextBoolean();
        if (vkOn) {
            notifier = new VkNotifier(notifier);
        }

        System.out.println("Telegram оповещения? ");
        boolean telegramOn = sc.nextBoolean();
        if (telegramOn) {
            notifier = new TelegramNotifier(notifier);
        }

        System.out.println("Sms оповещения? ");
        boolean smsOn = sc.nextBoolean();
        if (smsOn) {
            notifier = new SmsNotifier(notifier);
        }

        notifier.notifySomebody();
    }

    // Поведенческие (Наблюдатель/Observer, Итератор/Iterator) - паттерны, настраивающие поведение объектов
    static void observer() {

    }

    static void iterator() {
        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(12);
        arr.add(2);
        arr.add(3);
        arr.add(4);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        Iterator<Integer> iterator = arr.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public static void main(String[] args) {
        // GsonBuilder - настройка создаваемого объекта
//        builderExamples();
//        scanner();
//        formatting();
//        singleton();
//        multiThreadBadSingleton();
//        multiThreadGoodSingleton();
//        decorator();
        iterator();
    }
}
