package lesson8;

public class SmsNotifier extends BaseNotifierDecorator {

    public SmsNotifier(Notifier wrapee) {
        super(wrapee);
    }

    @Override
    public void notifySomebody() {
        System.out.println("Оповещение по SMS");
        wrapee.notifySomebody();
    }
}
