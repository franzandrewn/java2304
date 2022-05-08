package lesson6;

public class Person implements Comparable<Person> {
    String name;
    int age;

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
