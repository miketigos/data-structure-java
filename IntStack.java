
package dataStructuresJava;

import java.util.EmptyStackException;


public class IntStack implements Stack<Integer>{

	private int[] stack;
    private int index = 0;

    public IntStack(int size) {
        stack = new int[size];
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
	public void push(Integer n) throws Exception {
		if (index > stack.length - 1) {
            throw new Exception("Stack is full");
        }
        stack[index++] = n;
	}

	@Override
	public Integer pop() {
        if (!this.isEmpty()) {
		    return stack[--index];
        }
        throw new EmptyStackException();
	}

	@Override
	public Integer peek() {
		if (!this.isEmpty()) {
		    return stack[index - 1];
        }
        return -1;
	}
 
}
