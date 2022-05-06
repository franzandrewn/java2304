package lesson4;

/*
Взять любой из классов последних занятий и переопределить в нём методы toString, equals и hashCode
В toString использовать любой вариант создания/форматирования строк для вывод информации об объекте
В hashCode использовать метод Objects.hash для генерации уникального числа из всех полей объекта
В equals определить своё правило сравнения объектов (например, сравнивать по всем полям кроме одного)
Лучше всего использовать возможность "Generate" от IDEA (обычно Alt+Insert или пр.кл.мыши -> Generate)
 */
public class HW4 {
    public static void main(String[] args) {
        SportCar s = new SportCar("a", "b", 1);
        SportCar s1 =  new SportCar("a", "b", 1);
        System.out.println(s);
        System.out.println(s.equals(s1));
    }
}
