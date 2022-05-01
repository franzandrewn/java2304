package lesson4;

import lesson3.Person;

import java.util.Arrays;

public class Main {
    static void abstraction() {
        // Абстракция
        // 1. Классы являются моделью реальных вещей/сущностей,
        // но в класс в виде полей/методов мы записываем только то, что важно в предметной области
        // 2. Не обязательно знать как класс устроен, важно лишь знать как его использовать
    }

    static void inheritance() {
        // Наследование - возможность создать класс на основе другого класса
        // При этом все поля и методы из класса-предка будут в классе-потомке
        // ремарка: конструкторы предка не существуют в потомке
        // Синтаксис наследования: extends имя_предка в определении класса
        Employee e = new Employee("Vanya", 24, 1000.1);
        e.print();
        System.out.println(e.getMoney());
        // Есть возможность добавлять новые поля и новые методы
        e.setRole("manager");
        System.out.println(e.roleToString());

        // Есть возможность изменять как работают методы предка - переопределение
        // Метод print() в Employee - переопределение метода print() в Person
        Person p = new Person("Vanya", 24, 1000.1);
        p.print();

        // Множественное наследование невозможно в Java

        // Класс java.lang.Object - предок любого класса в Java
        // toString
        // Строки 35 и 36 идентичны
        System.out.println("Сотрудник создан: " + e);
        System.out.println(e.toString());

        // getClass()
        // Работа с классами как с объектами
        System.out.println(e.getClass().getName());
        System.out.println(Employee.class.getName());

        // equals() - проверка не равенство двух объектов
        // В Object equals() проверяет равенство ссылок
        Employee e2 = e;
        System.out.println(e.equals(e2));
        Employee e3 = new Employee("Vanya", 24, 1000.1);
        e3.setRole("manager");
        System.out.println(e.equals(e3));

        // hashCode() - получение уникального целого числа для объекта
        System.out.println(e.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e3.hashCode());
    }

    static int add(int x, int y) {
        System.out.println("int");
        return x + y;
    }

    static double add(double x, double y) {
        System.out.println("double");
        return x + y;
    }

    static String add(String x, String y) {
        System.out.println("string");
        return x + y;
    }

    static void polymorphism() {
        // Полиморфизм - возможность работы метода с разными наборами аргументов
        // 1. "Истинный" полиморфизм - один код на разные наборы аргументов
        // 2. "Мнимый" полиморфизм - несколько единиц кода под разные наборы аргументов
        // 2.1. Приведение типов
        System.out.println(add(1, 3.4));
        // 2.2. Перегрузка методов - наличие нескольких методов с одним именем но разным набором аргументов
        System.out.println(add(1, 3));
        System.out.println(add(1, 3.4));
        System.out.println(add("a", "bc"));
    }

    static void packages() {
        // Пакеты - папки в которых содержится код java
    }

    static void encapsulation() {
        // Инкапсуляция
        // 1. Возможность языка заключать данные и действия над данными в одну "капсулу"
        // 2. Возможность ограничивать одним частям программы действия других частей программы

        // Модификаторы доступа
        // public - видно всему проекту
        // default - внутри пакета (у него нет ключевого слова)
        // protected - внутри пакета или в наследниках
        // private - видно только внутри класса
    }


    static void task1() {
        /*
        Создать класс Figure
        Три поля: целые числа x, y и строка color
        Два конструктора: без аргументов и со всеми аргументами (Alt+Insert)
        Два метода:
            toString(), который превращает объект в строку формата
                "Figure{x=.., y=.., color='..'}" (Alt+Insert)
            double distance(), который даст расстояние до (0,0) = Math.sqrt(x*x+y*y)
        В psvm создайте объект класса Figure через любой конструктор и проверьте оба метода
         */
        Figure f = new Figure(3, 4, "black");
        System.out.println(f);
        System.out.println(f.distance());
    }

    static void task2() {
        /*
        Создать класс Circle, наследующийся от Figure
        Добавить поле целого типа radius
        Определить конструкторы без аргументов и со всеми аргументами (здесь лучше вручную)
        Переопределить метод toString, чтобы был формат вывода "Circle{x=.., y=.., radius=.., color=..}"
        Добавить метод double area(), который считает площадь окружности по формуле Pi * radius * radius
        Pi записать вручную как значение или использовать Math.PI
        В psvm создать объект класса Circle через любой конструктор и проверить все три метода
         */
        Circle c = new Circle(-3, 4, "blue", 2);
        System.out.println(c);
        System.out.println(c.distance());
        System.out.println(c.area());
    }

    static void task3() {
        /*
        Добавить static метод paint в класс Main (рядом с psvm),
        который принимает два аргумента объект класса Figure с именем figure и строку с именем newColor
        и "перекрашивает" объект figure в цвет newColor
        (изменяет значение поля color у figure на newColor)
         */
        Figure f = new Figure(3,4,"black");
        System.out.println(f);
        paint(f, "white");
        System.out.println(f);
    }

    static void paint(Figure figure, String newColor) {
        figure.color = newColor;
    }



    static void abstractKeyword() {
        // abstract - ключевое слово, можно поставить перед классом и перед методами
        // Абстрактный класс - класс, у которого нельзя создать объекты
        // Абстрактный метод - метод без реализации (без {})
//        Car c = new Car(); // невозможно, потому что абстрактный класс
        SportCar sportCar = new SportCar("Ferrari", "F40", 250);
        sportCar.move();
        System.out.println(sportCar);
    }

    static void finalKeyword() {
        // final - ключевое слово, которое означает что что-то является финальной версией себя
        // final переменные
        final int i = 5;
//        i = 6; // нельзя, потому что i - финальная
        final int j;
        j = 1;
//        j = 5; // нельзя, потому что значение уже есть

        // final поля необходимо инициализировать, но нельзя менять

        // final методы нельзя переопределять

        // от final классов нельзя наследоваться
    }

    static void staticKeyword() {
        // static - ключевое слово, которое означает принадлежность поля/метода классу, а не объектам
        System.out.println(Person.getCount());
        Person p = new Person();
        System.out.println(Person.getCount());
        Person p2 = new Person();
        System.out.println(Person.getCount());

        System.out.println(p);
        System.out.println(p2);
//        Person.setCount(4);
//        System.out.println(Person.getCount());
    }

    static void interfaces() {
        // Интерфейсы - структурная единица,
        // которая может в себе содержать только определения методов (без реализации) и константы
        // Классы могут реализовывать интерфейсы
        Printable[] printables = new Printable[]{new Person(), new SportCar()};
        for (int i = 0; i < printables.length; i++) {
            printables[i].print();
        }
    }

    static void inheritanceExample() {
        Person p = new Employee("Andrew", 23, 100);
        Number[] numbers = new Number[]{1, 2.5, 0.0001, -100};
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i].doubleValue();
        }
        System.out.println(sum);
    }

    static void task4() {
        /* HW0
        Создать интерфейсы СanSwim, СanFly с методами void swim() и void fly() соответственно
        Создать класс Duck, который реализует оба интерфейса
        и при плавании выводит "Кря, плаваю", при полете "Кря, летаю"
        Создать класс Plane, который реализует интерфейс canFly
        и при полете выводит "Сжигаю керосин"
        В psvm создать объекты классов Duck и Plane и вызвать у них доступные методы
         */
    }

    public static void main(String[] args) {
        // 4 принципа ООП
        // 1. Абстракция
        abstraction();
        // 2. наследование
        inheritance();
        // 3. полиморфизм
        polymorphism();
        // пакеты (ремарка)
        packages();
        // 4. инкапсуляция
        encapsulation();
        // task1
        task1();
        // task2
        task2();
        // task3
        task3();
        // ключевое слово abstract
        abstractKeyword();
        // ключевое слово final
        finalKeyword();
        // ключевое слово static
        staticKeyword();
        // интерфейсы
        interfaces();
        // Пример записи в переменную предка объекта наследника
        inheritanceExample();
        // task4
        task4();
    }
}
