package lesson4;

public class FinalExample {
    final int q = 5; // 1 вариант инициализации - сразу же в момент определения
    final double d;

    // 2 вариант инициализации - в конструкторе
    public FinalExample() {
        d = 5;
    }

    public FinalExample(double d) {
        this.d = d;
    }

    void changeQD() {
//        q = 100; // нельзя
//        d = 101; // нельзя
    }

    final void finalMethod() {
        System.out.println(1);
    }
}
