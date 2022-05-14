package lesson7;

public class NameTooLongException extends Exception {
    public NameTooLongException() {
        super("Имя слишком длинное");
    }
}
