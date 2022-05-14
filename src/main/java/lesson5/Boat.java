package lesson5;

public class Boat {
    private Engine engine;
    int capacity;

    public Boat(int capacity) {
        engine = new Engine();
        this.capacity = capacity;
    }

    public Boat(Engine engine, int capacity) {
        this.engine = engine;
        this.capacity = capacity;
    }

    void turnEngineOn() {
        System.out.println("Запускаю двигатель");
        engine.turnOn();
    }

    void turnEngineOff() {
        System.out.println("Выключаю двигатель");
        engine.turnOff();
    }

    void move() {
        if (engine.isOn()) {
            System.out.println("Плыву");
        } else {
            System.out.println("Не могу плыть, двигатель отключен");
        }
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
