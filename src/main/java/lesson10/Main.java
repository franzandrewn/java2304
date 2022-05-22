package lesson10;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1", Thread.currentThread());
//        MyThread t2 = new MyThread("t2", Thread.currentThread());
        t1.start();
//        t2.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main: " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
