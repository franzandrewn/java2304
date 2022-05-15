package lesson8;

public class VkNotifier extends BaseNotifierDecorator {
    public VkNotifier(Notifier wrapee) {
        super(wrapee);
    }

    @Override
    public void notifySomebody() {
        System.out.println("Оповещение Вконтакте");
        wrapee.notifySomebody();
    }
}
