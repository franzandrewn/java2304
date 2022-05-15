package lesson7;

import com.google.gson.annotations.Expose;

import java.util.Arrays;

public class Human {
    @Expose
    String firstName;
    @Expose
    String lastName;
    boolean isAlive;
    @Expose int age;
    private Address address;
    PhoneNumber[] phoneNumbers;
    Human[] children;
    Human spouse;

    public Human() {
    }

    public Human(String firstName, String lastName, boolean isAlive, int age, Address address, PhoneNumber[] phoneNumbers, Human[] children, Human spouse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAlive = isAlive;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.children = children;
        this.spouse = spouse;
    }

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

    public String getCity() {
        return this.address.city;
    }

    public String getFullName() {return firstName + lastName;}

    public int getAge() {
        return age;
    }
}
