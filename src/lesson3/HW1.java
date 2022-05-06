package lesson3;

/*
Внутри HW1 добавить метод с именем div, который принимает два дробных числа и возвращает их частное
 */
public class HW1 {
    static double div(double x, double y) {
        return x / y;
    }

    public static void main(String[] args) {
        System.out.println(div(1, 5));
        System.out.println(div(2, 0));
    }
}
