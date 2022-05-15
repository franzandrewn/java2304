package lesson8;

public class BaseNotifierDecorator implements Notifier{
    protected Notifier wrapee;

    public BaseNotifierDecorator(Notifier wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public void notifySomebody() {
        wrapee.notifySomebody();
    }
}
