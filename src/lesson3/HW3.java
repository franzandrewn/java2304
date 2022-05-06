package lesson3;

/*
Создать класс PhoneNumber (в отдельном файле)
2 поля:
num целочисленного типа
    (там будет храниться номер в виде числа, начинающегося с 8)
numType строчного типа
    (там будет храниться информация о типе номера, например "Рабочий" или "Личный")
В psvm создать объект класса PhoneNumber, задать его полям значения через операцию присваивания
Вывести информацию об объекте в консоль в одну строку
 */
public class HW3 {
    public static void main(String[] args) {
        PhoneNumber number = new PhoneNumber();
        number.num = 89991231212L;
        number.numType = "рабочий";
        System.out.println("Телефон (" + number.numType + ") " + number.num);
    }
}
