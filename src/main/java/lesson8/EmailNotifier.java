package lesson8;

public class EmailNotifier implements Notifier{

    @Override
    public void notifySomebody() {
        System.out.println("Оповещение по email");
    }
}
