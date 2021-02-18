package dataStructuresJava;

import java.util.EmptyStackException;

/**
 * @author Michael Thomas
 * 
 * My implementation of a generic stack interface
*/

public interface Stack<T> {

    // returns the size/height of the stack
    public int size();

    // boolean return type reflects whether or not stack
    //contains zero elements
    public boolean isEmpty();

    // adds an element to the top of the stack if it is not
    // full if it is full throws a stack overflow exceptiion
    public void push(T x) throws Exception;

    // removes the top-most element of the stack and returns it
    public T pop() throws EmptyStackException;

    // returns the top-most element of the list 
    // without altering the stack
    public T peek();
    
}
