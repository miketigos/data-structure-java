package dataStructuresJava;

// Linked list implementation of a queue ADT
// * First = Front of queue; Last = Back of queue

import java.util.NoSuchElementException;

public class Queue<T extends Comparable<T>> {

    private LinkedList<T> queue;

    //--constructors--//
    // default - creates and empty queue
    public Queue() {
        queue = new LinkedList<>();
    }

    // instantiate with an initial element
    public Queue(T data) {
        queue = new LinkedList<>(data);
    }

    public T peek() {
        if (!queue.isEmpty()) {
            return queue.peekFirst();
        }
        return null;
    }

    public T element() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.peekFirst();
    }

    public boolean offer(T data) {
        queue.addLast(data);
        return true;
    }

    public T poll() {
        if (!queue.isEmpty()) {
            return queue.removeFirst();
        }
        return null;
    }

    public T remove() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }

    public String toString() {
        return queue.toString();
    }
}
