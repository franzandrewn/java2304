package lesson1;

import java.util.Scanner;

/*
Спросить у пользователя число
Если оно попадает в диапазон от 1 до 100 или в диапазон от -1000 до -100, вывести в консоль "+"
Если оно не попадает ни в один из этих диапазонов, вывести "-"
 */
public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 1 вариант
        if (n >= 1 && n <= 100) {
            System.out.println("+");
        } else if (n >= -1000 && n <= -100) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }

        // 2 вариант
        if ((n >= 1 && n <= 100) || (n >= -1000 && n <= -100)) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }
    }
}
