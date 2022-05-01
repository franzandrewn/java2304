package lesson4;

public class Circle extends Figure {
    int radius;

    public Circle() {
    }

    public Circle(int x, int y, String color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }

    double area() {
        return Math.PI * radius * radius;
    }
}
