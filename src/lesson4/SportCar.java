package lesson4;

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
}
