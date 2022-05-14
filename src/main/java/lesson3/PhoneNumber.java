package lesson3;

public class PhoneNumber {
    // HW3
    long num;
    String numType;

    public PhoneNumber() {
        numType = "";
    }

    public PhoneNumber(long num, String numType) {
        this.num = num;
        this.numType = numType;
    }

    void print() {
        System.out.println("Телефон (" + numType + ") " + num);
    }

    void changeType(String newType) {
        numType = newType;
    }

    long getNum() {
        return num;
    }
}
