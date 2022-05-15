package lesson8;

public class TelegramNotifier extends BaseNotifierDecorator {
    public TelegramNotifier(Notifier wrapee) {
        super(wrapee);
    }

    @Override
    public void notifySomebody() {
        System.out.println("Оповещение Telegram");
        wrapee.notifySomebody();
    }
}
