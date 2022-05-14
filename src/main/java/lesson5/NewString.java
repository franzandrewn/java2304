package lesson5;

public class NewString {
    private String value;

    public NewString(String value) {
        this.value = value;
    }

    public int indexOf(int ch) {
        return value.indexOf(ch);
    }
}
