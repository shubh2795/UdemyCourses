package stack.stackWithArray;

import java.util.EmptyStackException;

public class ArrayStack {
    private int[] stack;
    private int top;

    public  ArrayStack(int capacity) {
        stack = new int[capacity];
        top =0;
    }

    public void push(int data) {
        if (top == stack.length) {
            // array has to be resized
            int[] arr = new int[2 * stack.length];
            System.arraycopy(stack, 0, arr, 0, stack.length);
            stack = arr;
        }
        stack[top++] = data;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();
        int temp = stack[--top];
        stack[top] = 0;
        return temp;

    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }
    public int size(){
        return top;
    }

    public void printStack(){
        System.out.println("Printing Stack : ");
        if(isEmpty())
            System.out.println("Empty Stack");
        else{
            for(int i=top-1;i>=0;i--){
                System.out.println(stack[i]);
            }
        }
    }

}
