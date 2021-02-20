package dataStructuresJava;

public class LinkedList<T extends Comparable<T>> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {

        T data;
        Node next = null;
        Node previous = null;

        private Node(T data) {

            this.data = data;
        }

        private Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public LinkedList(T data) {

        head = tail = new Node(data);
    }

    public int size() {

        return size;
    }

    public void add(T data) {
        if (size == 0) {
            addFirst(data);
        } else {
            addLast(data);
        }
    }

    public T peekFirst() {

        return head.data;
    }

    public void addFirst(T data) {
        if (size == 0) {
            head = tail = new Node(data);

        } else {
            Node node = new Node(data);
            head.previous = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(T data) {
        if (size == 0) {
            tail = head = new Node(data);

        } else {
            Node node = new Node(data);
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    public T removeLast() {
        T data = tail.data;
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        } else if (size == 1) {
            tail = head = null;
        } else if (size > 1) {
            tail = tail.previous;
            tail.next.previous = tail.next = null;
        }
        size--;
        return data;


    }

    public T removeFirst() {
        T data = head.data;
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        } else if (size == 1) {
            head = tail = null;
        } else if (size > 1) {
            head = head.next;
            head.previous.next = head.previous = null;
        }
        size--;
        return data;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        }
        else {
            Node cur = head;
            int i = 0;
            while (i < index) {
                cur = cur.next;
                i++;
            }
            cur.previous.next = cur.next;
            cur.next.previous = cur.previous;
            size--;

        }
    }

    public boolean contains(T data) {
        Node cur = head;
        int i = 0;
        while (i < size - 1) {
            if (cur.data.equals(data)) {
                return true;
            }
            cur = cur.next;
            i++;
        }
        return false;

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    // Helper Method for remove
    public int getIndexOfFirstOccurence(T data) {

        if (size == 1 && head.data.equals(data)) {
            return 0;
        } else if (size > 1) {
            Node cur = head;
            int i = 0;
            while (i < size - 1) {
                if (cur.data.equals(data)) {
                    return i;
                }
                cur = cur.next;
                i++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void delete(T data) {
        if (this.contains(data)) {
            remove(getIndexOfFirstOccurence(data));
        }
    }

    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        Node cur = head;
        int i = 0;
        while (i < size - 1) {
            sb.append(cur.data + ", ");
            cur = cur.next;
            i++;
        }
        sb.append(cur.data + "]");
        return sb.toString();
    }
}

