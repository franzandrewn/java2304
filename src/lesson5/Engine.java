package lesson5;

public class Engine {
    private boolean isOn;

    public Engine() {
        isOn = false;
    }

    void turnOn() {
        isOn = true;
    }

    void turnOff() {
        isOn = false;
    }

    boolean isOn() {
        return isOn;
    }
}
