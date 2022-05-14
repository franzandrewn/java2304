package lesson4;

/*
Создать два класса Tree и Bush, наследующиеся от класса Plant
    У обоих классов будут конструкторы работающие так же, как и конструктор Plant
    Метод grow в классе Tree будет увеличивать поле с высотой на 0.9
    Метод grow в классе Bush будет увеличивать поле с шириной на 0.05
В psvm создать объекты Tree и Bush, вывести их поля, вызвать метод grow и вывести поля ещё раз
Задание со "звездочкой":
    Создать массив с типом данных Plant, поместить туда созданные ранее объекты классов Tree и Bush
    С помощью цикла for получить каждое растение и вызвать у него метод grow()
 */
public class HW2 {
    public static void main(String[] args) {
        Tree t = new Tree(1, 0.5);
        Bush b = new Bush(1, 0.5);

        System.out.println(t);
        System.out.println(b);
        t.grow();
        b.grow();
        System.out.println(t);
        System.out.println(b);

        Plant[] plants = new Plant[]{t, b};
        for (int i = 0; i < plants.length; i++) {
            plants[i].grow();
            System.out.println(plants[i]);
        }
    }
}
