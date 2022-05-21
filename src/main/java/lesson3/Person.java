package lesson3;

import lesson4.Printable;

import java.util.Objects;

public class Person implements Printable {
    private static int count = 0;

    public static int getCount() {
        return count;
    }
//
//    public static void setCount(int newCount) {
//        count = newCount;
//    }

    // Состояние объектов: список полей
    public String name;
    public int age;
    public double money;
    public int id;

    public Person() {
        count++;
        id = count;
    }

    public Person(String name, int age, double money) {
        count++;
        id = count;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Person(String name, int age) {
        count++;
        id = count;
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // Поведение объектов: список методов
    public void print() {
        System.out.println("Человек с именем: " + name + ", возрастом: " + age);
    }

    public String getMoney() {
        return money + "$";
    }

    // переопределение метода toString


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age
                && Double.compare(person.money, money) == 0
                && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, money);
    }

    // static часть класса
//    static Person person1 = new Person();
//    static Person person2 = new Person();
}
