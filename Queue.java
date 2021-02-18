package dataStructuresJava;

/**
 * Linked list implementation of a queue ADT
 * First = Front of queue; Last = Back of queue
 *
 */

public class Queue<T extends Comparable<T>> {

    private LinkedList<T> queue;

    // constructors
    public Queue() {
        queue = new LinkedList<>();
    }

    public Queue(T data) {
        queue = new LinkedList<>(data);
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        return queue.peekFirst();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return (queue.size() == 0);
    }

    public void offer(T data) {
        queue.addLast(data);
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        return queue.removeLast();
    }

    public String toString() {
        return queue.toString();
    }

}
