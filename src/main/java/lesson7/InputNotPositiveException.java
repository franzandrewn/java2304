package lesson7;

// Новое исключение (необрабатываемое)
// с сообщением "Ввод неположительный"
public class InputNotPositiveException extends RuntimeException {
    public InputNotPositiveException() {
        super("Ввод неположительный");
    }
}
