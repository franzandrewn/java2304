package lesson4;

import java.util.Objects;

public class SportCar extends Car {

    public SportCar() {
    }

    public SportCar(String manufacturer, String model, int maxSpeed) {
        super(manufacturer, model, maxSpeed);
    }

    @Override
    public void move() {
        System.out.println("быстро еду со скоростью " + maxSpeed);
    }

    @Override
    public void print() {
        System.out.println("быстрая машина");
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, maxSpeed);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SportCar)) return false;
        SportCar sportCar = (SportCar) obj;
        return this.hashCode() == sportCar.hashCode();
    }
}
