package lesson7;

public class PhoneNumber {
    String type;
    String number;

    public PhoneNumber() {
    }

    public PhoneNumber(String type, String number) {
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
