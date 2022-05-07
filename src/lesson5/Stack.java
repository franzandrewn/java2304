package lesson5;

import java.util.LinkedList;

public class Stack {
    private LinkedList<Integer> values;

    public Stack() {
        values = new LinkedList<>();
    }

    public int size() {
        return values.size();
    }

    public void push(Integer i) {
        values.add(i);
    }

    public Integer pop() {
        return values.remove(values.size() - 1);
    }

    public Integer peek() {
        return values.get(values.size() - 1);
    }

    @Override
    public String toString() {
        return "Stack" +
                values;
    }
}
