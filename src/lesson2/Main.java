package lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // оператор switch
        int i = 4;
        switch (i) {
            case 1:
                System.out.println("Пн");
                break;
            case 2:
                System.out.println("Вт");
                break;
            case 3:
                System.out.println("Ср");
                break;
            case 4:
                System.out.println("Чт");
                break;
            case 5:
                System.out.println("Пт");
                break;
            case 6:
                System.out.println("Сб");
                break;
            case 7:
                System.out.println("Вс");
                break;
            default:
                System.out.println("Неправильный день недели");
        }

        // массивы - возможность под одним именем хранить много значений одного и того же типа в определенном порядке
        // массивы являются статической структурой, которая не может изменяться по длине
        // индексы - порядковые номера начинающиеся с 0
        // создание переменной массива
        // тип_значений[] имя_массива;
        int[] intArray;

        // инициализация переменной массива
        // 1. Создание массива по длине массива
        // У каждого примитивного типа есть значение по умолчанию:
        // byte, short, int, long -> 0; float, double -> 0.0; boolean -> false; char -> символ с 0 номером
        // У ссылочных типов значение по умолчанию - null (отсутствие значение)
        intArray = new int[5];

        // 2. Создание массива на основе значений
        double[] doubleArray = new double[]{1.1, 2.2, 3.3};

        // Действия с массивами
        // Получить количество элементов .length
        System.out.println("intArray length: " + intArray.length);
        System.out.println("doubleArray length: " + doubleArray.length);

        // Вывести содержимое массива
        System.out.println(intArray);
        System.out.println(doubleArray);
        System.out.println("Массив intArray: " + Arrays.toString(intArray));
        System.out.println("Массив doubleArray: " + Arrays.toString(doubleArray));

        // Взаимодействие с элементов по его индексу
        System.out.println("Второй элемент в doubleArray: " + doubleArray[1]);
//        System.out.println(doubleArray[-1]); // несуществующий индекс
//        System.out.println(doubleArray[3]); // несуществующий индекс

        System.out.println("Первый элемент intArray перед изменением: " + intArray[0]);
        intArray[0] = 100;
        System.out.println("Первый элемент intArray после изменения: " + intArray[0]);
//
//        // Взять последний элемент
        System.out.println("Последний элемент в doubleArray: " + doubleArray[doubleArray.length - 1]);

        // Циклы - возможность повторить код несколько раз
        // цикл while (пока)
        int q = 5;
        while (q <= 100) {
            System.out.println(q);
            q = q + 5;
        }
        System.out.println("После цикла q: " + q);

        // Бесконечный цикл
        q = 0;
//        while (q <= 0) {
//            System.out.println(q);
//            q = q - 1;
//        }

        // Спросить у пользователя N чисел, вывести их квадраты в ответ
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько чисел вы хотите ввести?");
        int n = sc.nextInt();
        while (n > 0) {
            System.out.println("Введите целое число");
            int k = sc.nextInt();
            System.out.println("Ваше число в квадрате = " + (k*k));
            n = n - 1;
        }

        // do..while {
        q = 5;
        do {
            System.out.println(q);
            q = q - 1;
        } while (q > 0);

        // цикл for
        System.out.println("Цикл for");
        for (int index = 5; index <= 100; index = index + 5) {
            System.out.println(index);
        }

        // Возможно, но не стоит использовать (если приходится, написать комментарий)
        for (int index = 0, j = 2; index + j < 14; index = index + 2, j = j - 1) {
            System.out.println(index + " " + j);
        }

        // continue и break
        // continue - пропустить все действия после continue и вернуться на проверку условия
        int j = 10;
        while (j < 20) {
            if (j == 15) {
                j = j + 1;
                continue;
            }
            System.out.println(j);
            j = j + 1;

        }
        // break - выйти из цикла без условий
        System.out.println("break");
        j = 10;
        while (j < 20) {
            if (j == 15) {
                break;
            }
            System.out.println(j);
            j = j + 1;

        }
        System.out.println(j);

        System.out.println("Введите положительное число");
        int positiveInt;
        while (true) {
            positiveInt = sc.nextInt();
            if (positiveInt > 0) {
                break;
            } else {
                System.out.println("Неверно, введите положительное число");
            }
        }
        System.out.println(positiveInt);

        // Инкремент, декремент
        int var = 1;
        var++;
        System.out.println(var);
        var--;
        System.out.println(var);

        // Работа с массивами через циклы
        int[] numbers = new int[100];
        System.out.println(Arrays.toString(numbers));
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = index + 1;
        }
        System.out.println(Arrays.toString(numbers));

        // Каждый нечетный элемент увеличить на 1
        for (int index = 0; index < numbers.length; index++) {
            int element = numbers[index]; // создать переменную со значением на индексе
            if (element % 2 != 0) { // в случае если элемент нечетный
                numbers[index] = element + 1; // положить на индекс старый элемент + 1
            }
        }
        System.out.println(Arrays.toString(numbers));

        for (int index = 0; index < numbers.length; index = index + 5) {
            System.out.println(numbers[index]);
        }

        // task1
        /*
        Создать массив с любыми целыми значениями
        С помощью цикла вывести все четные элементы, а нечетные заменить на 0
        Пример:
        Массив до [1,2,3,4,5]
        Массив после [0,2,0,4,0] + вывести 2, 4
         */
        int[] ints = new int[]{5, 0, 3, 4, 100};
        for (int index = 0; index < ints.length; index++) {
            int element = ints[index];
            if ((element % 2) != 0) {
                // Если число нечетное - заменить элемент на 0
                ints[index] = 0;
            } else {
                // В обратном случае (число четное) - вывести элемент на экран
                System.out.println(element);
            }
        }
        System.out.println(Arrays.toString(ints));

        // task2
        /*
        Создать массив с любыми дробными числами
        С помощью цикла положительные элементы вывести на экран в виде "Положительный элемент: 5.4"
        А все отрицательные элементы и ноль вывести в виде "Неположительный элемент: -2.0001"
        Пример:
        Массив [-1.001, 5.89, 0]
        Вывод на экран:
        "Неположительный элемент: -1.001"
        "Положительный элемент: 5.89"
        "Неположительный элемент: 0.0"
         */
        double[] doubles = new double[]{-1.001, 5.89, 0};
        for (double d : doubles) {
            if (d > 0) {
                System.out.println("Положительный элемент: " + d);
            } else {
                System.out.println("Неположительный элемент: " + d);
            }
        }

        // task3
        /*
        Спросить у пользователя целое положительное число m
        (если хотите, через бесконечный цикл)
        Создать массив дробных чисел длиной m
        Заполнить каждый элемент по формуле i * i + 0.5 , где i - индекс элемента
        Вывести весь массив на экран
         */

        // for..each
        System.out.println("For each");
        int index = 0;
        for (double d: doubles) {
            System.out.println("Элемент на индексе: " + index + " со значением: " + d);
            index += 1;
        }

        // Краткое изменение переменных
        index = 0;

        index += 5; //index = index + 5;
        System.out.println(index);
        index -= 2; // index = index - 2;
        System.out.println(index);
        index *= 7; // index = index * 7;
        System.out.println(index);
        index /= 2; // index = index / 2;
        System.out.println(index);
        index %= 4; // index = index % 4;
        System.out.println(index);

        // Префиксная запись и постфиксная запись
        int l = 5;
        l++;
        ++l;
        l--;
        --l;

        l = 5;
        System.out.println(5 * l++); // 5 * 5, а потом l += 1
        System.out.println(l);
        l = 5;
        System.out.println(5 * ++l); // сначала l += 1, а потом 5 * 6

        l = 5;
        System.out.println(l++ * ++l); // каверзный вопрос
        System.out.println(l);

        // Тернарный оператор
        int x = sc.nextInt();
        x = x < 0? -x: x;
        if (x < 0) {
            x = -x;
        } else {
            x = x;
        }
        System.out.println(x);

        String s = sc.nextLine();
        boolean b = s.equals("Да")? true: false;
        if (s.equals("Да")){
            b = true;
        } else {
            b = false;
        }
        System.out.println(b);

        String answer = s.equals("Да")? "Положительный ответ": s.equals("Нет")? "Отрицательный ответ": "Нет ответа";
        if (s.equals("Да")) {
            answer = "Положительный ответ";
        } else if (s.equals("Нет")) {
            answer = "Отрицательный ответ";
        } else {
            answer = "Нет ответа";
        }
        System.out.println(answer);

        // Math
        // pow - возведение одного числа в степень второго числа
        System.out.println(Math.pow(2, 10));
        System.out.println(Math.sqrt(2));
        // PI, E - константы
        System.out.println(Math.PI);
        System.out.println(Math.E);

        // Тригонометрия
        // sin, cos, tan ..
        System.out.println(Math.sin(0));
        System.out.println(Math.cos(0));
        System.out.println(Math.tan(0));

        // Действия над числами
        // max, min
        System.out.println(Math.min(4, 5));
        // abs - модуль числа
        System.out.println(Math.abs(-5));
        System.out.println(Math.abs(5));
        // Округления
        System.out.println(Math.ceil(1.1));
        System.out.println(Math.ceil(1.5));
        System.out.println(Math.ceil(1.9));

        System.out.println(Math.floor(1.1));
        System.out.println(Math.floor(1.5));
        System.out.println(Math.floor(1.9));

        System.out.println(Math.round(1.1));
        System.out.println(Math.round(1.5));
        System.out.println(Math.round(1.9));

        // log, exp
        System.out.println(Math.log(Math.E));
        System.out.println(Math.exp(1));

        // random
        System.out.println(Math.random()); // случайное число от 0 включая до 1 не включая
        System.out.println(((int)(Math.random() * 101)) - 50); // случайное число от -50 включая до 50 включая

        // Arrays
        // Сравнить массивы на равенство
        System.out.println(Arrays.equals(doubleArray, new double[]{1.1, 2.2, 3.3}));
        // Отсортировать массив
        double[] doubles1 = new double[]{2.2, 3.3, 1.1};
        Arrays.sort(doubles1);
        System.out.println(Arrays.toString(doubles1));
        // Если массив отсортирован, то можно найти индекс элемента
        System.out.println(Arrays.binarySearch(doubles1, 2.2));
    }
}
