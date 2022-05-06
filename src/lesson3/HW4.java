package lesson3;

/*
Добавить в класс PhoneNumber два конструктора:
первый - без аргументов, он задает значение numType = ""
второй - с двумя аргументами таких же типов, что и поля, он передает значения аргументов в поля
В psvm создать два объекта класса PhoneNumber
    первый - с помощью конструктора без аргументов и потом задать значения его полей
    второй - с помощью конструктора с двумя аргументами
Вывести информацию об обоих объектах по одному на строку
 */
public class HW4 {
    public static void main(String[] args) {
        PhoneNumber p1 = new PhoneNumber();
        p1.num = 89991231212L;
        p1.numType = "рабочий";
        PhoneNumber p2 = new PhoneNumber(89991231212L, "рабочий");
        System.out.println("Телефон (" + p1.numType + ") " + p1.num);
        System.out.println("Телефон (" + p2.numType + ") " + p2.num);
    }
}
