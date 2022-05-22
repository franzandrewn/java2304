package lesson10;

public class MyThread extends Thread {
    Thread fromThread;

    public MyThread(String name, Thread fromThread) {
        super(name);
        this.fromThread = fromThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread " + getName() + ": " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
