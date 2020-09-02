package stack.stackWithList;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListStack {
    private final LinkedList<Integer> stack;

    public ListStack() {
        stack = new LinkedList<Integer>();
    }

    public void push(int data) {
        stack.push(data);
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();
        return stack.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void printStack() {
        if (isEmpty())
            System.out.println("Empty Stack");
        ListIterator<Integer> iter = stack.listIterator();
        while ( iter.hasNext() ) {
            System.out.println(iter.next());
        }
    }

}
