package lesson3;


import java.util.Arrays;

// Задание со звездочкой
/*
Написать метод quadraticEq, который принимает три дробных числа a,b,c как параметры
и вычисляет корни квадратного уравнения
Учесть, что корней может не быть, что их может быть 1 или 2
Результат "собрать" в массив дробных чисел
Например, параметры 1 2 1 дадут массив = {-1}, потому что a*x*x + b*x + c = 0
А параметры 1 7 12 дадут массив = {-3, -4}
 */
public class HW6 {
    static double[] quadraticEq(double a, double b, double c) {
        double[] result;
        double dis = b * b - 4 * a * c;
        if (dis > 0) {
            double x1 = (- b + Math.sqrt(dis)) / (2 * a);
            double x2 = (- b - Math.sqrt(dis)) / (2 * a);
            result = new double[]{x1, x2};
        } else if (dis == 0) {
            double x = -b / (2 * a);
            result = new double[]{x};
        } else {
            result = new double[0];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quadraticEq(1, 6, 5)));
        System.out.println(Arrays.toString(quadraticEq(1, 2, 1)));
        System.out.println(Arrays.toString(quadraticEq(1, 2, 5)));

    }
}
