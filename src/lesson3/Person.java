package lesson3;

public class Person {

    // Состояние объектов: список полей
    String name;
    int age;
    double money;

    Person() {}

    Person(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.money = 0.0;
    }

    // Поведение объектов: список методов
    void print() {
        System.out.println("Человек с именем: " + name + ", возрастом: " + age);
    }

    String getMoney() {
        return money + "$";
    }

    // static часть класса
    static Person person1 = new Person();
    static Person person2 = new Person();
}
