/*
Name: Davis Haden
Date Last Edited: 10/24/2021
Desc: Circle stack class. When an object is pushed past the limit, the first value is replaced with it instead.
*/
package jsjf;


import jsjf.exceptions.EmptyCollectionException;

public class CircleStack<t> {
    private final static int DEFAULT_CAPACITY = 5;

    private int top;
    private final t[] stack;

    public CircleStack()
    {
        this(DEFAULT_CAPACITY);
    }
    public CircleStack(int initialCapacity) {
        top = 0;
        stack = (t[])(new Object[initialCapacity]);
    }

    public void push(t element) {
        if(top < stack.length) {
            stack[top] = element;
            top++;
        }
        if (top == stack.length) {
            stack[0] = element;
            //System.out.println("Replacing first value...");
        }
    }

    public t pop() throws EmptyCollectionException{
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        top--;
        t result = stack[top];
        stack[top] = null;

        return result;
    }

    public t peek() {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack[top-1];
    }

    public boolean isEmpty() {
        return (top <= 0);
    }

    public int size() {
        return top;
    }
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        for (int i = top-1; i > 0; i--) {
            str.append(stack[i]).append(", ");
        }
        if(stack[0] != null){
            str.append(stack[0]);
        }
        return str.toString();
    }
}
