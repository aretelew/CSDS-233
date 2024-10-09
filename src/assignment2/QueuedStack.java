package assignment2;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class QueuedStack<T> {
    private Queue<T> queue;

    public QueuedStack() {
        this.queue = new LinkedList<T>();
    }

    public T push(T element) {
        queue.add(element);
        return element;
    }

    public T pop() {
        if (queue.peek() == null) {
            throw new EmptyStackException();
        }

        Queue<T> reducedQueue = new LinkedList<T>();
        int size = queue.size();
        T tail = null;

        for (T element : queue) {
            tail = element;
        }
        for (int i = 0; i < size - 1; i++) {
            T element = queue.poll();
            reducedQueue.add(element);
        }

        queue = reducedQueue;
        return tail;
    }
    public T peek() {
        if (queue.peek() == null) {
            throw new EmptyStackException();
        }
        T tail = null;
        for (T element : queue) {
            tail = element;
        }
        return tail;
    }

    public boolean empty() {
        if (queue.peek() == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return queue.toString();
    }
}
