package lesson3;

/*
Добавить в класс PhoneNumber три метода:
метод с именем print без аргументов и без возвращаемого значения,
    print выводит объект в консоль в одну строку
метод с именем changeType с одной строкой как аргумент и без возвращаемого значения,
    changeType изменяет значение поля numType на строку из аргумента
метод с именем getNum без аргументов и с возвратом целочисленного значения,
    getNum возвращает значение поля num
В psvm создать объекты как в HW4
Вызвать у второго объекта метод print(),
с помощью sout и getNum() вывести отдельно значение номера,
вызвать у объекта changeType() со значением строчного типа,
снова вызвать метод print()
 */
public class HW5 {
    public static void main(String[] args) {
        PhoneNumber p = new PhoneNumber(89991231212L, "рабочий");
        PhoneNumber p1 = new PhoneNumber();
        p1.num = 89991231212L;
        p1.numType = "рабочий";
        PhoneNumber p2 = new PhoneNumber(89991231212L, "рабочий");

        p2.print();
        System.out.println(p2.getNum());
        p2.changeType("мобильный");
        p2.print();
    }
}
