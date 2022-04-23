public class Main {
    public static void main(String[] args) {
        // Простейшая программа - выводит строку "Привет мир!" и выводит 7 в разных строках
        /*
        Первая строка комментария
        Вторая строка комментария
         */
        // sout - аббревиатура для System.out.println();
//        System.out.println("\"Привет мир!\"");
//        System.out.println(2 + 5);

        // Арифметические действия
        // Целые числа
//        System.out.println("Арифметические действия над целыми числами");
//        System.out.println(2 + 5);
//        System.out.println(2 - 5);
//        System.out.println(2 * 5);
//        System.out.println(13 / 5); // Целочисленное деление (в ответе целая часть от деления)
//        System.out.println(13 % 5); // Остаток от деления//
//        System.out.println(5 / 0); // Деление на 0 - ошибка

        // Дробные числа
//        System.out.println("Арифметические действия над дробными числами");
//        System.out.println(2.0 + 5.0);
//        System.out.println(2.0 - 5.0);
//        System.out.println(2.0 * 5.0);
//        System.out.println(13.0 / 5.0); // Полное деление
//        System.out.println(13.0 % 5.0);

        // Строки - текстовый тип данных
//        System.out.println("Единственное 'арифметическое' действие над строками");
//        System.out.println("Левая часть строки" + " " + "Правая часть строки");

        // Порядок операций - работают правила математики
//        System.out.println("Порядок операция");
//        System.out.println(2 + 3 * 5);
//        System.out.println((2 + 3) * 5);
//        System.out.println(33 % 17 / 3); // 33 % 17 = 16; 16 / 3 = 5
//        System.out.println(34 / 3 % 3); // 34 / 3 = 11; 11 % 3 = 2

        // "Стиль" кода
        // IDEA - Ctrl + Alt + L


        // Переменные - имена для значений какого-нибудь типа данных
        // Создание переменной
        // Тип_данных имя_переменной;
        int count;


        // Инициализация переменной - первичное задание значения
        // Операция '=' - присваивание значения какой-либо переменной
        count = 0;
        System.out.println(count);
        System.out.println(count + 10);

        // Имена переменных
        // Имена переменных (и не только) начинаются с буквы, '_' или '$', после этого можно ещё использовать цифры
        // Регистр в именах важен, то есть people =/= People
        // Неверное имя - начинается с цифры
//        int 8people;
        // Корректное имя - начинается с буквы
        int people8;
        // несколько слов пишутся слитно с большими буквами в начале слов
        // первое слово начинается с маленькой буквы
        // аббревиатуры начинаются с большой, продолжаются маленькими
        int personAge;
        int personSalary;
        int ageOfMsu;

        count = 1;
        System.out.println(count);
        System.out.println(count + 10);

        // Типы данных
        // 1. Примитивные типы данных (ключевые слова Java)
        // 2. Ссылочные типы данных (массивы, классы и т.д.)

        // Примитивные типы данных
        // Целые числа
        // byte, 1 байт, -128..127
        byte b = -126;
        System.out.println(b);
        // Невозможно положить значение выходящее за пределы
//        byte incorrectByte = 128;

        // short, 2 байт, -32,768..32,767
        short s = 32000;
        System.out.println(s);

        // int, 4 байта, -2,147,483,648..2,147,483,647
        int i = 2000000000;
        System.out.println(i);

        // long, 8 байта, -9,223,372,036,854,775,808 .. 9,223,372,036,854,775,807
        long l = 9000000000000000000L;
        System.out.println(l);

        // Дробные числа
        // float, 4 байта
        float fl = 4.5f;
        System.out.println(fl);

        // double, 8 байт
        double d = 4.5;
        System.out.println(d);

        // И float, и double подчиняются международному стандарту IEEE 754
        System.out.println(5.0 / 2.1);
        System.out.printf("%.4f\n", 5.0 / 2.1); // souf
        System.out.printf("%d\n", 5 / 3);

        System.out.println(0.1 + 0.2);
        System.out.println(5 / 0.0);
        System.out.println(5 / (-0.0));

        // Символы

        // Логический тип данных

        // Операции сравнения


    }
}
