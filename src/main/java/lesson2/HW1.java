package lesson2;

import java.util.Arrays;

/*
Создать массив дробных чисел double длиной 5 с именем doubles
Вывести массив с помощью Arrays.toString()
Заполнить по очереди все элементы с помощью операции получения элемента по индексу
Вывести массив с помощью Arrays.toString()
Изменить первый элемент на 1.00001, последний элемент на -0.189
Вывести массив с помощью Arrays.toString()
 */
public class HW1 {
    public static void main(String[] args) {
        double[] doubles = new double[5];
        System.out.println(Arrays.toString(doubles));

        // 1 вариант заполнения
        doubles[0] = 1;
        doubles[1] = 2;
        doubles[2] = 4;
        doubles[3] = 8;
        doubles[4] = 16;
        System.out.println(Arrays.toString(doubles));

        // 2 вариант заполнения
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = i + 1;
        }
        System.out.println(Arrays.toString(doubles));

        doubles[0] = 1.00001;
        doubles[doubles.length - 1] = -0.189;
        System.out.println(Arrays.toString(doubles));
    }
}
