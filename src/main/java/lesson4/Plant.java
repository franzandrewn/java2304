package lesson4;

public abstract class Plant implements Growing {
    double height;
    double width;

    public Plant() {
    }

    public Plant(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void grow() {
        System.out.println("Я расту");
    }

    @Override
    public String toString() {
        return "Plant{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
