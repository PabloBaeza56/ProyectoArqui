package dataStructures;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> elements;

    public Stack() {
        elements = new ArrayList<>();
    }

    public void push(T element) {
        elements.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public void clear() {
        elements.clear();
    }
}
