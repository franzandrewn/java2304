package lesson3;

public class Animal {
    String name;
    int age;
    String kind;

    void print() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Вид: " + kind);
    }

    void makeSound() {
        if (kind.equals("cat")) {
            System.out.println("мяу");
        } else if (kind.equals("dog")) {
            System.out.println("гав");
        } else {
            System.out.println("звук");
        }
    }
}
