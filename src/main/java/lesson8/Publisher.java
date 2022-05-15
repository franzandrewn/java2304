package lesson8;

import java.util.LinkedList;

public class Publisher {
    private LinkedList<Subscriber> subscribers = new LinkedList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    private void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.doSomething();
        }
    }
}
