package lesson6;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {
    public String name;
    public int age;
    public static int count = 0;
    public transient String password;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.age == o.age) {
            return this.name.length() - o.name.length();
        } else {
            return this.age - o.age;
        }
    }
}
