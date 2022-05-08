package lesson6;

import lesson3.Animal;

public class Cage<A extends Animal> {
    private A animal;
    double height;
    double width;
    double length;

    public Cage(A animal, double height, double width, double length) {
        this.animal = animal;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Cage(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public A getAnimal() {
        return animal;
    }

    public void setAnimal(A animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Cage{" +
                "animal=" + animal +
                ", height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
