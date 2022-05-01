package lesson4;

import lesson3.Person;

import java.util.Objects;

public class Employee extends Person {
    private String role;

    Employee(String name, int age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public void print() {
        System.out.println("Сотрудник с именем: " + name + ", возрастом: " + age);
    }

    String roleToString() {
        return "Моя должность: " + role;
    }

    public String getRole() {
        // проверки на авторизацию и т.п.
        return role;
    }

    public void setRole(String role) {
        // проверки на авторизацию и т.п.
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name)
                && age == employee.age
                && money == employee.money
                && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, money, role);
    }
}
