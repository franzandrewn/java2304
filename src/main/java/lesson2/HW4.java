package lesson2;

import java.util.Arrays;
import java.util.Scanner;

/*
Спросить у пользователя целое положительное число m
Создать целочисленный массив длины m
С помощью цикла (for или while) заполнить этот массив из ввода пользователя,
т.е. спросить у пользователя целое число m раз и записать эти числа по очереди в массив
Вывести массив с помощью Arrays.toString()
Задание со "звёздочкой":
рассчитать сумму элементов в массиве и вывести её
 */
public class HW4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while (m < 1) {
            System.out.println("Введите число > 0");
            m = sc.nextInt();
        }

        // гарантия, что n > 0
        int[] ints = new int[m];
        for (int i = 0; i < ints.length; i++) {
            System.out.println("Пожалуйста введите " + i + " по индексу элемент");
            ints[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(ints));

        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        System.out.println("Сумма элементов в массиве: " + sum);
    }
}
