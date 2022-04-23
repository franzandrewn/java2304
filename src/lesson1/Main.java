package lesson1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Простейшая программа - выводит строку "Привет мир!" и выводит 7 в разных строках
        /*
        Первая строка комментария
        Вторая строка комментария
         */
        // sout - аббревиатура для System.out.println();
        System.out.println("\"Привет мир!\"");
        System.out.println(2 + 5);

        // Арифметические действия
        // Целые числа
        System.out.println("Арифметические действия над целыми числами");
        System.out.println(2 + 5);
        System.out.println(2 - 5);
        System.out.println(2 * 5);
        System.out.println(13 / 5); // Целочисленное деление (в ответе целая часть от деления)
        System.out.println(13 % 5); // Остаток от деления//
//        System.out.println(5 / 0); // Деление на 0 - ошибка

        // Дробные числа
        System.out.println("Арифметические действия над дробными числами");
        System.out.println(2.0 + 5.0);
        System.out.println(2.0 - 5.0);
        System.out.println(2.0 * 5.0);
        System.out.println(13.0 / 5.0); // Полное деление
        System.out.println(13.0 % 5.0);

        // Строки - текстовый тип данных
        System.out.println("Единственное 'арифметическое' действие над строками");
        System.out.println("Левая часть строки" + " " + "Правая часть строки");

        // Порядок операций - работают правила математики
        System.out.println("Порядок операция");
        System.out.println(2 + 3 * 5);
        System.out.println((2 + 3) * 5);
        System.out.println(33 % 17 / 3); // 33 % 17 = 16; 16 / 3 = 5
        System.out.println(34 / 3 % 3); // 34 / 3 = 11; 11 % 3 = 2

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
        // char, 1 - 4 байт
        char c = 'n';
        System.out.println(c);
        c = 'Ю';
        System.out.println(c);
        c = '国';
        System.out.println(c);
        System.out.println((char)('a' + 1));

        // Логический тип данных
        boolean bool = true;
        System.out.println(bool);
        bool = false;
        System.out.println(bool);

        // Преобразование типов - превращение значения одного типа в значение другого типа
        // 1. Восходящее - тип меньшей длины преобразуем в тип большей длины
        byte smallVar = 12;
        int bigVar = (int) smallVar;
        // 2. Нисходящее - тип большей длины преобразуем в тип меньшей длины
        int bigInt = 127;
        byte smallByte = (byte) bigInt;
        System.out.println(smallByte);
        int bigInt2 = 129;
        byte smallByte2 = (byte) bigInt2;
        System.out.println(smallByte2);

        // Операции сравнения
        System.out.println(5 > 2); // true
        System.out.println(2 > 5); // false

        System.out.println(5 < 2); // false
        System.out.println(2 < 5); // true

        System.out.println(5 >= 5); // true
        System.out.println(5 <= 5); // true

        // проверка на равенство
        System.out.println(5 == 5); // true
        System.out.println(5 == 6); // false

        System.out.println(0.1 + 0.2 - 0.3 < 0.0000000000000001);

        // проверка на неравенство
        System.out.println(5 != 5); // false
        System.out.println(5 != 6); // true

        boolean is5equals5 = 5 == 5;
        System.out.println(is5equals5);

        // Условный оператор - возможность исполнить блок кода только по определенному условию
        if (5 > 0) {
            // Всё внутри фигурных скобочек у условия выполнится, если условие истинно
            System.out.println("Первое условие было истинным");
            System.out.println("И правда первое условие истинно");
        }

        // блок кода else - выполняется, если условие ложно
        if (5 < 0) {
            System.out.println("Второе условие было истинным");
            System.out.println("И правда второе условие истинно");
        } else {
            System.out.println("Второе условие было ложным");
            System.out.println("И правда второе услоие ложно");
        }

        // task1
        /*
        Создать переменную double balance с любым некрасивым числом (без большого числа нулей в конце)
        Создать переменную double percent с любым числом (пусть будет от 17.0 до 21.0)
        Расчитать balance через год, если деньги положить под указанный percent
        суммаИзначально * (1 + процент / 100)
         */
        double balance = 80000;
        double percent = 19.5;
        balance = balance * (1 + percent / 100);
        System.out.println(balance);

        // task2
        /*
        В случае если на балансе больше 100 000, вывести строку "Много денег"
        В обратном случае вывести строку "Мало денег"
         */
        if (balance > 100000) {
            System.out.println("Много денег");
        } else {
            System.out.println("Мало денег");
        }

        int dayOfWeek = -5;
        if (dayOfWeek == 0) {
            System.out.println("0");
        } else if (dayOfWeek > 0) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }

        if (dayOfWeek == 1) {
            System.out.println("Пн");
        } else if (dayOfWeek == 2) {
            System.out.println("Вт");
        } else if (dayOfWeek == 3) {
            System.out.println("Ср");
        } else if (dayOfWeek == 4) {
            System.out.println("Чт");
        } else if (dayOfWeek == 5) {
            System.out.println("Пт");
        } else if (dayOfWeek == 6) {
            System.out.println("Сб");
        } else if (dayOfWeek == 7) {
            System.out.println("Вс");
        } else {
            System.out.println("неправильный день");
        }

        // Операции с логическими типами
        // Отрицание (not) - взять обратное значение
        System.out.println("Отрицание");
        System.out.println(!true);
        System.out.println(!false);

        // Или (or) - результат ложный только если оба значения ложны (результат истина, если хотя бы один истина)
        System.out.println("Или");
        System.out.println(false || false);
        System.out.println(false || true);
        System.out.println(true || false);
        System.out.println(true || true);

        // И (and) - результат истинный только если оба значения истинны (результат ложный, если хотя бы один ложный)
        System.out.println("И");
        System.out.println(false && false);
        System.out.println(false && true);
        System.out.println(true && false);
        System.out.println(true && true);

        dayOfWeek = 9;
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            System.out.println("Неправильный день");
        }

        dayOfWeek = 5;
        if (dayOfWeek >= 1 && dayOfWeek <= 7) {
            System.out.println("Правильный день");
        }

        // Побитовые операции
        System.out.println(5 & 1);
        System.out.println(5 | 1);
        System.out.println(5 ^ 1);

        System.out.println(5 << 2);
        System.out.println(5 * 4);

        System.out.println(21 >> 2);
        System.out.println(21 / 4);

        // Ввод из консоли
        // Создание сканера с источником данных - ввод от пользователя
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число");
        // nextInt() - прочитать целое число из ввода пользователя
        int input = sc.nextInt();
        System.out.println(input);

        System.out.println("Введите сумму на счётё");
        balance = sc.nextDouble();
        System.out.println("Введите проценты");
        percent = sc.nextDouble();
        balance = balance * (1 + percent / 100) * (1 + percent / 100);
        System.out.println("Через 2 года у вас будет " + balance + " у.е.");

        System.out.println("Хотите вывести средства?");
        boolean out = sc.nextBoolean();
        if (out) {
            System.out.println("средств не осталось, вот вам " + balance);
        } else {
            System.out.println("средств: " + balance);
        }

        // String - строковый тип данных (набор символов)
        String str = "Привет, это программа!";
        // length - длина строки (количество символов)
        System.out.println(str.length());
        // charAt - получить символ по индексу (порядковый номер начиная с 0)
        System.out.println(str.charAt(6));
        // equals - проверить на равенство с другой строкой
        System.out.println(str.equals("Привет, это программа!"));
        // equalsIgnoreCase - проверить на равенство, не учитывая регистр
        System.out.println(str.equalsIgnoreCase("привет, это программа!"));
        // isEmpty - проверка не пустоту (на то, что в строке нет символов)
        System.out.println(str.isEmpty());
        // indexOf - найти первый индекс символа или строчки внутри указанной
        System.out.println(str.indexOf("это"));
        System.out.println(str.indexOf('а'));
        System.out.println(str.lastIndexOf('а'));
        // contains - узнать, есть ли символ или строка внутри указанной
        System.out.println(str.contains("это"));
        System.out.println(str.contains("Это"));
        // startsWith - строка начинается с определенной строки
        System.out.println(str.startsWith("Привет"));
        // endsWith - строка заканчивается на определенную строку
        System.out.println(str.endsWith("!"));
        // replace - заменить символ/строку на символ/строку
        System.out.println(str.replace('а', 'б'));
        System.out.println(str.replace("Привет", "Пока"));
        // toUpperCase/toLowerCase - все буквы превратить в большие/маленькие буквы
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
    }
}
