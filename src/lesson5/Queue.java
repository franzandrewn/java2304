package lesson5;

import java.util.LinkedList;

public class Queue {
    private LinkedList<Integer> values;

    public Queue() {
        values = new LinkedList<>();
    }

    public int size() {
        return values.size();
    }

    public void queue(Integer i) {
        values.add(i);
    }

    public Integer dequeue() {
        return values.remove(0);
    }

    public Integer peek() {
        return values.get(0);
    }

    @Override
    public String toString() {
        return "Queue" +
                values;
    }
}