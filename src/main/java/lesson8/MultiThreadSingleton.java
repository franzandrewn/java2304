package lesson8;

public class MultiThreadSingleton {
    public String value;

    private static volatile MultiThreadSingleton instance;

    private MultiThreadSingleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static MultiThreadSingleton getInstance(String value) {
        if (instance != null) {
            return instance;
        }
        synchronized (MultiThreadSingleton.class) {
            if (instance == null) {
                instance = new MultiThreadSingleton(value);
            }
            return instance;
        }
    }
}
