package lesson2;

import java.util.Scanner;

/*
Спросить у пользователя одно целое число типа int
С помощью цикла while вывести столько же раз фразу "Цикл while"
 */
public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        // обработка отрицательного ввода
        count = Math.abs(count);

        while (count > 0) {
            System.out.println("Цикл while");
            count -= 1;
        }
    }
}
