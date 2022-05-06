package lesson4;

public final class CircleMath {
    static final double pi = Math.PI;

    private CircleMath(){}

    static double length(double radius) {
        return 2 * pi * radius;
    }

    static double area(double radius) {
        return pi * radius * radius;
    }
}
