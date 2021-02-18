package dataStructuresJava;

import java.util.EmptyStackException;

public class CharStack implements Stack<Character>{

    private char[] stack;
    private int index = 0;

    public CharStack(int size) {
        stack = new char[size];
    }
    @Override
    public int size() {
        return index;
    }
    @Override
    public boolean isEmpty() {
        return (index == 0);
    }

    @Override
    public Character peek() {
        return stack[index - 1];
    }

    @Override
    public void push(Character c) throws Exception {
        if (index > stack.length - 1) {
            throw new Exception("Stack is full");
        }
        stack[index++] = c;
    }

    @Override
    public Character pop() {
        if (!this.isEmpty()) {
            return stack[--index];
        } else {
            throw new EmptyStackException();
        }

    }
}
