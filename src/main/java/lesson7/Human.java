package lesson7;

import java.util.Arrays;

public class Human {
    String firstName;
    String lastName;
    boolean isAlive;
    int age;
    Address address;
    PhoneNumber[] phoneNumbers;
    Human[] children;
    Human spouse;

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isAlive=" + isAlive +
                ", age=" + age +
                "\naddress=" + address +
                "\nphoneNumbers=" + Arrays.toString(phoneNumbers) +
                "\nchildren=" + Arrays.toString(children) +
                ", spouse=" + spouse +
                '}';
    }
}
