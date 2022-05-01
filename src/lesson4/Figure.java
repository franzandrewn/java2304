package lesson4;

public class Figure {
    int x;
    int y;
    String color;

    public Figure() {
    }

    public Figure(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public String toString() {
        return "Figure{" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                '}';
    }

    double distance() {
        return Math.sqrt(x * x + y * y);
    }
}
